package com.wqh.jpa.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @ClassName JpaFirstConfiguration
 * @Author wqh
 * @Date 2021/1/5 15:01
 * @Description TODO
 * @Version 1.0
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.wqh.jpa.dao", entityManagerFactoryRef = "testEntityManagerFactoryBean", transactionManagerRef = "testTransactionManager")
@EnableTransactionManagement
public class JpaConfiguration {

    //第一个数据源，可以不加Qualifier
    @Resource
    @Qualifier("dataSourceTest")
    private DataSource dataSource;

    //jpa其他参数配置
    @Resource
    private JpaProperties jpaProperties;

    //实体管理工厂builder
    @Resource
    private EntityManagerFactoryBuilder factoryBuilder;


    @Resource
    private HibernateProperties hibernateProperties;

    private Map<String, Object> getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
    }

    /**
     * 配置第一个实体管理工厂的bean
     *
     * @return
     */
    @Bean(name = "testEntityManagerFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        return factoryBuilder
                .dataSource(dataSource)// 设置数据源
                .properties(jpaProperties.getProperties())// 设置jpa配置
                .properties(getVendorProperties())// 设置hibernate配置
                .packages("com.wqh.jpa.entity") //设置实体类所在位置
                .persistenceUnit("primaryPersistenceUnit")// 设置持久化单元名，用于@PersistenceContext注解获取EntityManager时指定数据源
                .build();
    }

    /**
     * EntityManager不过解释，用过jpa的应该都了解
     *
     * @return
     */
    @Bean(name = "testEntityManager")
    @Primary
    public EntityManager entityManager() {
        return entityManagerFactoryBean().getObject().createEntityManager();
    }

    /**
     * jpa事务管理
     *
     * @return
     */
    @Bean(name = "testTransactionManager")
    @Primary
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }
}