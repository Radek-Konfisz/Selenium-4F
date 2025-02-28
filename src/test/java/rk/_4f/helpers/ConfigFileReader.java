package rk._4f.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    private final Properties properties;
    private static final Logger logger = LoggerFactory.getLogger(ConfigFileReader.class);

    public ConfigFileReader(String propertyFilePath) {
        properties = new Properties();
        try {
            properties.load(new FileReader(System.getProperty("user.dir") + propertyFilePath));
        } catch (IOException e) {
            logger.error("Error occurred in operation", e);
            throw new RuntimeException("Configuration properties not found at " + System.getProperty("user.dir")
                    + propertyFilePath);
        }
    }

    public String getProperty(String propertyName) {
        String property = properties.getProperty(propertyName);
        if (property != null) return property;
        else throw new RuntimeException("Given property " + propertyName +
                "not not specified in the config properties file");
    }

}
