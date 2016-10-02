package com.sample.app;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String args[]) {
        logger.info(sayHello());
        Runnable runnable = () -> logger.info(getFormattedDateAndTime()); // sample usage of lambda expression
        runnable.run();
    }

    public static String sayHello() {
        return "Hello!";
    }

    public static String getCurrentDateTime() {
        DateTime dateTime = new DateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.toString(dateTimeFormatter);
    }

    public static String getFormattedDateAndTime() {
        return String.format("Current date and time is: %s", getCurrentDateTime());
    }
}
