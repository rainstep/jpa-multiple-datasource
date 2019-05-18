package com.example.jpamultipledatasource.config;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryA",
        basePackages = "com.example.jpamultipledatasource.dao.a",
        transactionManagerRef = "transactionManagerA"
)
public class DataSourceAConfig {


    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-a")
    public DataSource dataSourceA() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryA(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSourceA())
                .packages("com.example.jpamultipledatasource.model.a")
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager transactionManagerA(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryA(builder).getObject());
    }

}
