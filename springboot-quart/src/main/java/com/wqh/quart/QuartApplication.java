package com.wqh.quart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QuartApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartApplication.class, args);
    }

}
