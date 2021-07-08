package com.pipi.firstdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class FirstDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstDemoApplication.class, args);
    }

}
