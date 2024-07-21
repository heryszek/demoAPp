package com.qmapp.demo;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class QualityManagementSpringBootApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(QualityManagementSpringBootApplication.class).run(args);
    }
}

