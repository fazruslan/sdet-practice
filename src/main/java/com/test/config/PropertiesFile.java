package com.test.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    Properties prop = new Properties();
    String projectPath = System.getProperty("user.dir");
    InputStream input;

    {
        try {
            input = new FileInputStream(projectPath + "/src/main/java/com/test/config/config.properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String userEmail = prop.getProperty("usermail");
    public String userLogin = prop.getProperty("userlogin");
    public String userPass = prop.getProperty("userpassword");
    public String pageUrl = prop.getProperty("pageUrl");
}
