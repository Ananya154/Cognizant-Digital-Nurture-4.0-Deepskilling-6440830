package com.cognizant.springrestallexercises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringRestAllExercisesApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestAllExercisesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringRestAllExercisesApplication.class, args);
        LOGGER.info("Application Started Successfully");

        displayDate();
        //displayCountry();
        displayCountries();
    }

    public static void displayDate() {
        LOGGER.info("START - displayDate");

        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        try {
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", date.toString());
        } catch (Exception e) {
            LOGGER.error("Error parsing date", e);
        }

        LOGGER.info("END - displayDate");
    }

    public static void displayCountry() {
        LOGGER.info("START - displayCountry");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);

        LOGGER.debug("Country: {}", country);

        LOGGER.info("END - displayCountry");
    }

    public static void displayCountries() {
        LOGGER.info("START - displayCountries");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = context.getBean("countryList", List.class);

        for (Country country : countries) {
            LOGGER.debug("Country: {}", country);
        }

        LOGGER.info("END - displayCountries");
    }
}
