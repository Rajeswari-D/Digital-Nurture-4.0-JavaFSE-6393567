package com.cognizant.slf4j.exercise3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Logging to both console and file.");
        logger.debug("Debug message here.");
        logger.warn("Warning issued.");
        logger.error("An error occurred.");
    }
}
