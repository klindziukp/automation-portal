package com.dandelion.automationportal.support;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("test")
class EmbeddedMariaDbConfig {

    @Value("${app.mariaDB4j.databaseName}")
    private String databaseName;
    @Value("${app.mariaDB4j.userName}")
    private String databaseUserName;
    @Value("${app.mariaDB4j.databasePassword}")
    private String databasePassword;
    @Value("${spring.datasource.driver-class-name}")
    private String databaseDriver;

    @Bean
    MariaDB4jSpringService mariaDB4jSpringService() {
        return new MariaDB4jSpringService();
    }

    @Bean
    DataSource dataSource(MariaDB4jSpringService mariaDB4jSpringService) {
        // Create our database with default root user and no password
        try {
            mariaDB4jSpringService.getDB().createDB(databaseName);
        } catch (ManagedProcessException mpEx) {
            mpEx.printStackTrace();
        }

        DBConfigurationBuilder config = mariaDB4jSpringService.getConfiguration();
        return DataSourceBuilder.create().username(this.databaseUserName).password(this.databasePassword).url(
                config.getURL(this.databaseName)).driverClassName(this.databaseDriver).build();
    }
}