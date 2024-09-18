package com.example.table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class TableApplication {

    public static void main(String[] args) {
        SpringApplication.run(TableApplication.class, args);
    }
    @Bean
    public ServletRegistrationBean<Table> bean(){
        return new ServletRegistrationBean<>(new Table(),"/table");
    }@Bean
    public ServletRegistrationBean<Submit> beaen(){
        return new ServletRegistrationBean<>(new Submit(),"/submit");
    }
}
