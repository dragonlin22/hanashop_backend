package com.dragonlin.hanashopapi.utils;

import org.slf4j.LoggerFactory;

public class LogUtil {
    public static final String APP_NAME = "[HANASHOP] ";
    public static final String INFO = "INFO";
    public static final String WARNING = "WARNING";
    public static final String ERROR = "ERROR";

    private static String createMessageLog(String message) {
        return APP_NAME + message;
    }

    public static void log(Class clazz, String message, String type) {
        switch (type) {
            case INFO: {
                LoggerFactory.getLogger(clazz).info(createMessageLog(message));
                break;
            }
            case WARNING: {
                LoggerFactory.getLogger(clazz).warn(createMessageLog(message));
                break;
            }
            case ERROR: {
                LoggerFactory.getLogger(clazz).error(createMessageLog(message));
                break;
            }
        }
    }
}
