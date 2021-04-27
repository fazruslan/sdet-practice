package com.test.model.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class MailPage {

    private WebDriver driver;
    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String pageUrl = "https://mail.yandex.ru";
    public String letterTheme = "Simbirsoft theme";
    public String userEmail = "ruslanfazylyanov@yandex.ru";


    private final By mailPageSignInButtonSelector = By.xpath("//a[@class='control button2 button2_view_classic button2_size_mail-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow']");
    private final By mailWriteButtonSelector = By.xpath("//a[@class='mail-ComposeButton js-main-action-compose']");
    private final By letterRecepientFieldSelector = By.xpath("//div[@class='composeYabbles']");
    private final By letterThemeFieldSelector = By.xpath("//input[@class='composeTextField ComposeSubject-TextField']");
    private final By letterTextAreaSelector = By.xpath("//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_htmlplaceholder']");
    private final By sendLetterButtonSelector = By.xpath("//button[@class='control button2 button2_view_default button2_tone_default button2_size_l button2_theme_action button2_pin_circle-circle ComposeControlPanelButton-Button ComposeControlPanelButton-Button_action']");
    private final By backToIncomingSelector = By.xpath("//a[text()='Вернуться во \"Входящие\"']");


    public WebElement mailPageSignInButton () { return driver.findElement(mailPageSignInButtonSelector); }
    public WebElement mailWriteButton() { return driver.findElement(mailWriteButtonSelector); }
    public WebElement letterRecepientField() { return driver.findElement(letterRecepientFieldSelector); }
    public WebElement letterThemeField() { return driver.findElement(letterThemeFieldSelector); }
    public WebElement letterTextArea() { return driver.findElement(letterTextAreaSelector); }
    public WebElement sendLetterButton() { return driver.findElement(sendLetterButtonSelector); }
    public WebElement backToIncoming() { return driver.findElement(backToIncomingSelector); }

    public List<WebElement> lettersTheme = driver.findElements(By.xpath("//span[@title='Simbirsoft theme']"));


    public void clickMailPageSignInButton() { mailPageSignInButton().click(); }
    public void clickMailWriteButton() { mailWriteButton().click(); }
    public void typeLetterRecepient() { letterRecepientField().sendKeys(userEmail); }
    public void typeLetterTheme() { letterThemeField().sendKeys(letterTheme); }
    public void clickSendLetterButton() { sendLetterButton().click(); }
    public void clickToBackToIncoming() { backToIncoming().click(); }

}
