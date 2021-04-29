package com.test.model.pages;

import com.test.config.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class MailPage extends PageFactory {

    private WebDriver driver;
    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    PropertiesFile propertiesFile = new PropertiesFile();

    public String pageUrl = "https://mail.yandex.ru";
    public String letterTheme = "Simbirsoft theme";
    public String userEmail = propertiesFile.userEmail;


    @FindBy(xpath = "//div[@class='HeadBanner-ButtonsWrapper']/a[2]")
    private WebElement mailPageSignInButton;

    @FindBy(xpath = "//div[@class='passp-button passp-sign-in-button']/button")
    private WebElement mailAuthorizationSignInButton;

    @FindBy(xpath = "//img[@class='user-pic__image']")
    private WebElement userPicture;

    @FindBy(xpath = "//span[@class='user-account__name']")
    private WebElement userInfo;

    @FindBy(xpath = "//a[@title='Написать (w, c)']")
    private WebElement writeLetterButton;

    @FindBy(xpath = "//div[@class='composeYabbles']")
    private WebElement recepientField;

    @FindBy(xpath = "//div[@class='compose-LabelRow']/div/input")
    private WebElement themeField;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement letterTextArea;

    @FindBy(xpath = "//div[@class='ComposeControlPanel-Part']/div/button")
    private WebElement sendLetterButton;

    @FindBy(xpath = "//a[text()='Вернуться во \"Входящие\"']")
    private WebElement backToIncoming;

    @FindBy(xpath = "//span[@title='Simbirsoft theme']")
    public List<WebElement> letterCount;

    public void clickMailSignInButton() {
        mailPageSignInButton.click();
    }

    public void clickAuthorizationSignInButton() {
        mailAuthorizationSignInButton.click();
    }

    public void clickWriteLetterButton() {
        writeLetterButton.click();
    }

    public void typeLetterRecepient() {
        recepientField.sendKeys(userEmail);
    }

    public void typeLetterTheme() {
        themeField.sendKeys(letterTheme);
    }

    public void typeLetterContent() {
        letterTextArea.sendKeys("Найдено " + letterCount.size() + " писем\\ьма");
    }

    public void clickSendLetterButton() {
        sendLetterButton.click();
    }

    public void clickBackToIncoming() {
        backToIncoming.click();
    }

    public void clickUserPicture() {
        userPicture.click();
    }

    public String receiveUserLogin() {
        return userInfo.getText();
    }

    public int calculateLetterCount() {
        int count = letterCount.size();
        return count;
    }








}
