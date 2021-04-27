package com.test.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MailAuthorizationPage {

    public MailAuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;
    private final By loginTypeFieldSelector = By.xpath("//input[@id='passp-field-login']");
    private final By passwordTypeFieldSelector = By.xpath("//input[@id='passp-field-passwd']");
    private final By authorizationSignInButtonSelector = By.xpath("//button[@type='submit']");

    public String userLogin = "ruslanfazylyanov";
    public String userPassword = "atlaslas2";

    //public WebElement loginTypeField() { return driver.findElement(loginTypeFieldSelector); }
    //public WebElement authorizationSignInButton() { return driver.findElement(authorizationSignInButtonSelector); }
    //public WebElement passwordTypeField() { return driver.findElement(passwordTypeFieldSelector); }
    //public void typeLogin() { loginTypeField().sendKeys(userLogin); }
    //public void typePassword() { passwordTypeField().sendKeys(userPassword); }
    //public void clickAuthorizationButton() {
    //    authorizationSignInButton().click();
    //}

    @FindBy(xpath = "//input[@id='passp-field-login']") WebElement loginType;

    @FindBy(xpath = "//input[@id='passp-field-passwd']") WebElement passType;

    @FindBy(xpath = "//button[@type='submit']") WebElement authorizationButton;


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
