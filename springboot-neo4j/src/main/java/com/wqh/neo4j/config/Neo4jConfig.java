package com.wqh.neo4j.config;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * @ClassName Neo4jConfig
 * @Author wqh
 * @Date 2021/1/7 15:04
 * @Description TODO
 * @Version 1.0
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.wqh.neo4j.repository")
public class Neo4jConfig {
    @Value("${spring.neo4j.uri}")
    private String url;

    @Value("${spring.neo4j.authentication.username}")
    private String username;

    @Value("${spring.neo4j.authentication.password}")
    private String password;

    @Bean(name = "session")
    public Session neo4jSession() {
        Driver driver = GraphDatabase.driver(url, AuthTokens.basic(username, password));
        return driver.session();
    }
}
