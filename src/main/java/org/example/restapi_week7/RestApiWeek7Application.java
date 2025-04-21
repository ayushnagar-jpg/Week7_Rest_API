package org.example.restapi_week7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiWeek7Application {

    private static final Logger logger = LoggerFactory.getLogger(RestApiWeek7Application.class);

    public static void main(String[] args) {
        SpringApplication.run(RestApiWeek7Application.class, args);
        logger.info(" Application started successfully!");
    }
}