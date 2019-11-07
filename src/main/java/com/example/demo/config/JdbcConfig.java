package com.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import com.example.demo.config.JdbcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {
    @Bean
    public DataSource getDataSource(JdbcProperties jdbc){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(jdbc.getUrl());
        dataSource.setDriverClassName(jdbc.getDriverClassName());
        dataSource.setUsername(jdbc.getUsername());
        dataSource.setPassword(jdbc.getPassword());
        return dataSource;
    }


}
