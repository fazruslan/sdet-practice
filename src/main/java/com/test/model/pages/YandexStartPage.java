package com.test.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexStartPage {

    public YandexStartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;
    private final By signInButtonSelector = By.xpath("//div[text()='Войти']");
    private final By userInfoSelector = By.xpath("//span[@class='username desk-notif-card__user-name']");

    public String pageUrl = "https://yandex.ru";

    public WebElement signInButton() { return driver.findElement(signInButtonSelector); }
    public WebElement userInfo() { return driver.findElement(userInfoSelector); }
    public void clickSignInButton () { signInButton().click(); }



}
