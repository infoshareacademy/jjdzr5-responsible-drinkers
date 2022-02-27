package com.infoshareacademy.drinkers.service.properties;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationProperties {

    private static final Logger LOGGER = Logger.getLogger(ApplicationProperties.class.getName());

    private static final Path PATH_FILE_NAME = Paths.get("src", "main", "resources","app_01.properties");

    public static String getDatePattern() {
        Properties properties = readFileProperties(PATH_FILE_NAME);
        String result;
        if ((result = properties.getProperty("dateFormat")) != null) {
            return result;
        } else {
            LOGGER.log(Level.INFO, "Properties DATEFORMAT empty");
            return "";
        }
    }

    public static String getSortDirection() {
        Properties properties = readFileProperties(PATH_FILE_NAME);
        String result;
        if ((result = properties.getProperty("sort")) != null) {
            return result;
        } else {
            LOGGER.log(Level.INFO, "Properties SORT empty");
            return "";
        }
    }

    public static Properties getProperties() {
        return readFileProperties(PATH_FILE_NAME);
    }

    private static Properties readFileProperties(Path fileName) {
        Properties appProperties = new Properties();
        try {
            appProperties.load(new StringReader(Files.readString(fileName)));
        } catch (InvalidPathException e) {
            LOGGER.log(Level.INFO, "Path not found, " + e.getMessage());
        } catch (IOException e) {
            LOGGER.log(Level.INFO, "File read error, " + e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.INFO, "File error, " + e.getMessage());
        } catch (NullPointerException e) {
            LOGGER.log(Level.INFO, "File not found, " + e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "Reading properties Error " + e.getMessage());
        }
        return appProperties;
    }


}
