package com.axis360.generics;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetPropertiesValue {

    // config properties path
    public static String filePath = "./config.properties";

    // getPropertyValue
    public static String getPropertyValue(String key) {

        // instantiate Properties class(Java.Util)
        Properties properties = new Properties();

        try {
            // instantiate File class and pass filePath
            File file = new File(filePath);
            // instantiate FileInputStream class and pass file
            FileInputStream fileInput = new FileInputStream(file);
            // Correct comment needed !
            properties.load(fileInput);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // returns the value that matches the key
        return properties.getProperty(key);
    }
}
