package com.loock.thinkmore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author loock
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class ThinkmoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThinkmoreApplication.class, args);
    }

}
