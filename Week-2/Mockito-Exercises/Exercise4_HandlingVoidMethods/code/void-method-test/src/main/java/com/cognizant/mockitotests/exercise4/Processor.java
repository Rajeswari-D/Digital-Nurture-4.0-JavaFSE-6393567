package com.cognizant.mockitotests.exercise4;

public class Processor {
    private Logger logger;

    public Processor(Logger logger) {
        this.logger = logger;
    }

    public void process(String task) {
        logger.log("Processing: " + task);
    }
}
