package com.wqh.jpa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceConfiguration
 * @Author wqh
 * @Date 2021/1/5 14:59
 * @Description TODO
 * @Version 1.0
 */
@Configuration
public class DataSourceConfiguration {
    /**
     * 第一个数据连接，默认优先级最高
     *
     * @return
     */
    @Bean(name = "dataSourceTest")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource dataSourceFirst() {
        //这种方式的配置默认只满足spring的配置方式，如果使用其他数据连接（druid）,需要自己独立获取配置
        return DataSourceBuilder.create().build();
    }
}
