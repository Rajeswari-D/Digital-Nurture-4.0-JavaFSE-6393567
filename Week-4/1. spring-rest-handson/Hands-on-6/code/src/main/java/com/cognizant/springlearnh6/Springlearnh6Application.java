package com.cognizant.springlearnh6;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Springlearnh6Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Springlearnh6Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Springlearnh6Application.class, args);
        displayCountries();
    }

    public static void displayCountries() {
        LOGGER.info("START");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = context.getBean("countryList", List.class);

        for (Country country : countries) {
            LOGGER.debug("Country: {}", country.toString());
        }

        LOGGER.info("END");
    }
}
