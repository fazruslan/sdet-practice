package com.test.model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MailPage extends PageFactory {

    WebDriver driver;
    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String pageUrl = "https://mail.yandex.ru";
    public String letterTheme = "Simbirsoft theme";


    @FindBy(xpath = "//div[@class='HeadBanner-ButtonsWrapper']/a[2]")
    WebElement mailPageSignInButtonSelector;

    @FindBy(xpath = "//div[@class='passp-button passp-sign-in-button']/button")
    WebElement mailAuthorizationSignInButtonSelector;

    @FindBy(xpath = "//img[@class='user-pic__image']")
    WebElement userPictureSelector;

    @FindBy(xpath = "//span[@class='user-account__name']")
    WebElement userInfo;

    @FindBy(xpath = "//a[@title='Написать (w, c)']")
    WebElement writeLetterButtonSelector;

    @FindBy(xpath = "//div[@class='composeYabbles']")
    WebElement recepientFieldSelector;

    @FindBy(xpath = "//div[@class='compose-LabelRow']/div/input")
    WebElement themeFieldSelector;

    @FindBy(xpath = "//div[@role='textbox']")
    WebElement letterTextAreaSelector;

    @FindBy(xpath = "//div[@class='ComposeControlPanel-Part']/div/button")
    WebElement sendLetterButtonSelector;

    @FindBy(xpath = "//div[@class='ComposeDoneScreen-Wrapper']/div/div[2]/a")
    WebElement backToIncomingSelector;

    @FindBy(xpath = "//span[@title='Simbirsoft theme']")
    List<WebElement> letterCountSelector;


    public WebElement mailStartPageSignInButton() {
        return mailPageSignInButtonSelector;
    }

    public WebElement authorizationSignInButton() {
        return mailAuthorizationSignInButtonSelector;
    }

    public WebElement userPicture() {
        return userPictureSelector;
    }

    public WebElement writeLetterButton() {
        return writeLetterButtonSelector;
    }

    public WebElement recepientField() {
        return recepientFieldSelector;
    }

    public WebElement themeField() {
        return themeFieldSelector;
    }

    public List<WebElement> letterCount() {
        return letterCountSelector;
    }

    public WebElement sendButton() {
        return sendLetterButtonSelector;
    }

    public WebElement textArea() {
        return letterTextAreaSelector;
    }

    public WebElement backToIncoming() {
        return backToIncomingSelector;
    }

    public void clickMailStartSignInButton(WebElement mailStartPageSignInButton) {
        mailStartPageSignInButton.click();
    }

    public void clickAuthorizationSignInButton(WebElement authorizationSignInButton) {
        authorizationSignInButton.click();
    }

    public void clickUserPicture(WebElement userPicture) {
        userPicture.click();
    }

    public void clickWriteLetterButton(WebElement writeLetterButton) {
        writeLetterButton.click();
    }

    public void inputLetterRecepient(String userMail) {
        recepientField().sendKeys(userMail);
    }

    public void typeLetterTheme(String theme) {
        themeField().sendKeys(theme); }

    public void typeLetterContent(WebElement textArea) {
        textArea.sendKeys("Найдено " + letterCount().size() + " писем\\ьма"); }

    public void clickSendLetterButton(WebElement sendLetterButton) {
        sendLetterButton.click(); }

    public void clickBackToIncoming(WebElement backToIncoming) {
        backToIncoming.click(); }

    public String receiveUserLogin() {
        return userInfo.getText();
    }

    public int calculateLetterCount() {
        return letterCount().size(); }








}
