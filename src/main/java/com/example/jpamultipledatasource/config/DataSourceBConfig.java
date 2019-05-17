package com.example.jpamultipledatasource.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
public class DataSourceBConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-b")
    public DataSource dataSourceB() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public EntityManagerFactory entityManagerFactoryB(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSourceB()).build().getObject();
    }

    @Bean
    public EntityManager entityManagerB(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

//    @Bean
//    public DataSourceTransactionManager transactionManagerB() {
//        return new DataSourceTransactionManager(dataSourceB());
//    }
}
