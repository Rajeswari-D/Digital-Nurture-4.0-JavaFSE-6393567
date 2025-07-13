package com.cognizant.springlearnh1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springlearnh1Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Springlearnh1Application.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(Springlearnh1Application.class, args);
        LOGGER.info("END");
    }
}
