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

    public String letterTheme = "Simbirsoft theme";

    @FindBy(xpath = "//div[@class='HeadBanner-ButtonsWrapper']/a[2]")
    private WebElement mailPageSignInButton;

    @FindBy(xpath = "//div[@class='passp-button passp-sign-in-button']/button")
    private WebElement mailAuthorizationSignInButton;

    @FindBy(xpath = "//img[@class='user-pic__image']")
    private WebElement userPicture;

    @FindBy(xpath = "//span[@class='user-account__name']")
    private WebElement userInfo;

    @FindBy(xpath = "//span[@class='mail-ComposeButton-Text']")
    private WebElement writeLetterButton;

    @FindBy(xpath = "//div[@class='composeYabbles']")
    private WebElement recepientField;

    @FindBy(xpath = "//div[@class='compose-LabelRow']/div/input")
    private WebElement themeField;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement letterTextArea;

    @FindBy(xpath = "//div[@class='ComposeControlPanel-Part']/div/button")
    private WebElement sendLetterButton;

    @FindBy(xpath = "//div[@class='ComposeDoneScreen-Actions']/a")
    private WebElement backToIncoming;

    @FindBy(xpath = "//span[@title='Simbirsoft theme']")
    private List<WebElement> letterCount;

    public void clickMailStartSignInButton() {
        mailPageSignInButton.click();
    }

    public void clickAuthorizationSignInButton() {
        mailAuthorizationSignInButton.click();
    }

    public void clickUserPicture() {
        userPicture.click();
    }

    public void clickWriteLetterButton() {
        writeLetterButton.click();
    }

    public void inputLetterRecepient(String userMail) {
        recepientField.sendKeys(userMail);
    }

    public void typeLetterTheme(String theme) {
        themeField.sendKeys(theme);
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

    public String receiveUserLogin() {
        return userInfo.getText();
    }

    public int calculateLetterCount() {
        return letterCount.size();
    }
}
