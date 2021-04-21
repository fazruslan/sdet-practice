package com.test.utils;

import org.openqa.selenium.chrome.ChromeDriver;

public class Webdriver {

    public static ChromeDriver getChromeDriver() {
        String path = System.getProperty("user.dir");
        String chromeDriverPath = path + "//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        return new ChromeDriver();
    }
}
