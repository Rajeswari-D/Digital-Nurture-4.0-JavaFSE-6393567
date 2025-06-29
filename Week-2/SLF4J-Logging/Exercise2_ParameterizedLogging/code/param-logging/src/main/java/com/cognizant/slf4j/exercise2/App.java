package com.cognizant.slf4j.exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        String user = "Rajeswari";
        int age = 25;

        logger.info("User {} is {} years old", user, age);
        logger.debug("Debugging info for user: {}", user);
        logger.warn("Warning for user: {}", user);
    }
}
