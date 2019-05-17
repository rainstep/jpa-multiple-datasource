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

public class DataSourceAConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-a")
    public DataSource dataSourceA() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public EntityManagerFactory entityManagerFactoryA(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSourceA()).build().getObject();
    }

    @Bean
    public EntityManager entityManagerA(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

//    @Bean
//    @Primary
//    public DataSourceTransactionManager transactionManagerA() {
//        return new DataSourceTransactionManager(dataSourceA());
//    }
}
