package com.example.jpamultipledatasource.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryB",
        basePackages = "com.example.jpamultipledatasource.dao.b",
        transactionManagerRef = "transactionManagerB"
)
public class DataSourceBConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-b")
    public DataSource dataSourceB() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryB(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSourceB())
                .packages("com.example.jpamultipledatasource.model.b")
                .build();
    }

    @Bean
    public JpaTransactionManager transactionManagerB(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryB(builder).getObject());
    }
}
