package com.test.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexStartPage {

    public YandexStartPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    private By signInButtonSelector = By.xpath("//div[text()='Войти']");
    private By mailTitleButtonSelector = By.xpath("//div[@class='desk-notif-card__mail-title']");

    public String pageUrl = "https://yandex.ru";

    public WebElement signInButton() { return driver.findElement(signInButtonSelector); }

    public WebElement mailTitleButton() { return driver.findElement(mailTitleButtonSelector); }


    public void clickSignIn (WebElement signInButton) { signInButton.click(); }
    public void clickMailButton (WebElement mailTitleButton) { mailTitleButton.click(); }

}
