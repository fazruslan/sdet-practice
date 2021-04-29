package com.test.model.pages;

import com.test.config.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailAuthorizationPage {

    public MailAuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    final WebDriver driver;
    PropertiesFile propertiesFile = new PropertiesFile();


    public String userLogin = propertiesFile.userLogin;
    public String userPassword = propertiesFile.userPass;


    @FindBy(id = "passp-field-login")
    private WebElement loginType;

    @FindBy(id = "passp-field-passwd")
    private WebElement passType;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement authorizationButton;



    public void typeLogin() {
        loginType.sendKeys(userLogin);
    }

    public void typePassword() {
        passType.sendKeys(userPassword);
    }

    public void clickAuthorizationButton() {
        authorizationButton.click();
    }
}
