package com.infoshareacademy;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppProperties {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    private Properties appProperties;

    public AppProperties() {
        readFileWithProperties("app_01.properties");
    }

    public AppProperties(String propertiesFileName) {
        readFileWithProperties(propertiesFileName);
    }

    private void readFileWithProperties(String fileName) {
        Properties appProperties = new Properties();
        try {
            Path path = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", fileName);
            appProperties.load(new StringReader(Files.readString(path)));

            setAppProperties(appProperties);

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
    }

    public Properties getAppProperties() {
        return appProperties;
    }

    private void setAppProperties(Properties appProperties) throws Exception {
        this.appProperties = appProperties;
        if (appProperties == null) {
            throw new Exception("Empty Properties");
        }

    }

    public void printProperties() {
        if (appProperties != null) {
            for (Object o : appProperties.entrySet()) {
                System.out.println(o);
            }
        }
    }

    public String getDatePatern() {
        String result = "";
        if (appProperties != null) {
            result = appProperties.getProperty("dateFormat");
            if (!result.isEmpty()) {
                return result;
            }
        }
        result = "";
        return result;
    }

    public String getSortType() {
        String result = "";
        if (appProperties != null) {
            result = appProperties.getProperty("sort");
            if (!result.isEmpty()) {
                return result;
            }
        }
        result = "";
        return result;
    }
}
