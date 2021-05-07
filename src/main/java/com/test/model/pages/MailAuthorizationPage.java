package com.test.model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailAuthorizationPage {

    public MailAuthorizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    final WebDriver driver;

    @FindBy(id = "passp-field-login")
    WebElement loginType;

    @FindBy(id = "passp-field-passwd")
    WebElement passType;

    public void inputLogin(String userLogin){
        loginType.sendKeys(userLogin);
    }

    public void inputPassword(String userPass) {
        passType.sendKeys(userPass);
    }

}
