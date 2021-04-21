package com.test.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailAuthorizationPage {

    public MailAuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    private By loginTypeFieldSelector = By.xpath("//input[@id='passp-field-login']");
    private By passwordTypeFieldSelector = By.xpath("//input[@id='passp-field-passwd']");
    private By authorizationSignInButtonSelector = By.xpath("//button[@type='submit']");

    public String userLogin = "ruslanfazylyanov";
    public String userPassword = "atlaslas2";

    public WebElement loginTypeField() { return driver.findElement(loginTypeFieldSelector); }
    public WebElement authorizationSignInButton() { return driver.findElement(authorizationSignInButtonSelector); }
    public WebElement passwortTypeField() { return driver.findElement(passwordTypeFieldSelector); }

    public void clickAuthorizationButton(WebElement authorizationSignInButton) {
        authorizationSignInButton.click();
    }

}
