package com.abhinav.tutee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TuteeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TuteeApplication.class, args);
    }

}
