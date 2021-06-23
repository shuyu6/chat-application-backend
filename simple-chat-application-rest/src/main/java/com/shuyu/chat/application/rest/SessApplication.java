package com.shuyu.chat.application.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Log4j2
@SpringBootApplication
@EntityScan(basePackages = {"com.shuyu.chat.application.domain"})
@EnableJpaRepositories(basePackages = "com.shuyu.chat.application.domain.**")
public class SessApplication extends SpringBootServletInitializer {
    /**
     * This method is used to configure the main program activities
     * @param args this is pass in parameter
     */
    public static void main(String[] args) {
        SpringApplication.run(SessApplication.class, args);
    }

}
