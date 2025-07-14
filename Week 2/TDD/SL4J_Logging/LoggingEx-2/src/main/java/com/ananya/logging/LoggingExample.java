package com.ananya.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        String username = "Ananya";
        String operation = "Login";
        int userId = 101;
        logger.info("User {} with ID {} performed {} operation.", username, userId, operation);
        logger.warn("Low disk space warning for user {}", username);
        logger.error("Error loading profile for user ID {}", userId);
    }
}
