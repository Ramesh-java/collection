package com.example.webproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebprojectApplication.class, args);
    }
    @Bean
    public ServletRegistrationBean<SignupServlet>signupServletServletRegistrationBean(){
        return new ServletRegistrationBean<>(new SignupServlet(),"/signup");
    }
    @Bean
    public ServletRegistrationBean<LoginServlet>loginServletServletRegistrationBean(){
        return new ServletRegistrationBean<>(new LoginServlet(),"/login");
    }

}
