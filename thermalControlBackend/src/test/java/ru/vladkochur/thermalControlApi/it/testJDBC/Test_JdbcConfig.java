package ru.vladkochur.thermalControlApi.it.testJDBC;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import static ru.vladkochur.thermalControlApi.it.testcontainers.AbstractRestControllerBaseTest.POSTGRE_SQL_CONTAINER;


@TestConfiguration
public class Test_JdbcConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(POSTGRE_SQL_CONTAINER.getDriverClassName());
        dataSource.setUrl(POSTGRE_SQL_CONTAINER.getJdbcUrl().replace("jdbc:", "jdbc:tc:"));
        dataSource.setUsername(POSTGRE_SQL_CONTAINER.getUsername());
        dataSource.setPassword(POSTGRE_SQL_CONTAINER.getPassword());
        return dataSource; }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate( dataSource()); }
}
