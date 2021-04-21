import com.test.model.pages.MailAuthorizationPage;
import com.test.model.pages.MailPage;
import com.test.model.pages.YandexStartPage;
import com.test.utils.Webdriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestClass {


    @Test
    public void authorization() {
        WebDriver driver = Webdriver.getChromeDriver();

        YandexStartPage yandexStartPage = new YandexStartPage(driver);
        MailAuthorizationPage mailAuthorizationPage = new MailAuthorizationPage(driver);
        MailPage mailPage = new MailPage(driver);

        driver.get(yandexStartPage.pageUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        yandexStartPage.clickSignIn(yandexStartPage.signInButton());
        mailAuthorizationPage.loginTypeField().sendKeys(mailAuthorizationPage.userLogin);
        mailAuthorizationPage.clickAuthorizationButton(mailAuthorizationPage.authorizationSignInButton());
        mailAuthorizationPage.passwortTypeField().sendKeys(mailAuthorizationPage.userPassword);
        mailAuthorizationPage.clickAuthorizationButton(mailAuthorizationPage.authorizationSignInButton());


        String currentUserInfo = driver.findElement(By.xpath("//span[@class='username desk-notif-card__user-name']")).getText();
        Assert.assertEquals(mailAuthorizationPage.userLogin, currentUserInfo);

        driver.quit();

    }

    @Test
    public void checkMessageCount() {

        WebDriver driver = Webdriver.getChromeDriver();

        YandexStartPage yandexStartPage = new YandexStartPage(driver);
        MailAuthorizationPage mailAuthorizationPage = new MailAuthorizationPage(driver);
        MailPage mailPage = new MailPage(driver);


        driver.get(mailPage.pageUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        mailPage.clickMailPageSignInButton();
        mailAuthorizationPage.loginTypeField().sendKeys(mailAuthorizationPage.userLogin);
        mailAuthorizationPage.clickAuthorizationButton(mailAuthorizationPage.authorizationSignInButton());
        mailAuthorizationPage.passwortTypeField().sendKeys(mailAuthorizationPage.userPassword);
        mailAuthorizationPage.clickAuthorizationButton(mailAuthorizationPage.authorizationSignInButton());

        List<WebElement> letterBeforeSend = driver.findElements(By.xpath("//span[@title='Simbirsoft theme']"));

        int letterCountBeforeSend = letterBeforeSend.size();

        // тут мог перебрать список с помощью цикла, но были с этим проблемы, так как выводило на 1 меньше, поэтому так

        mailPage.clickMailWriteButton();
        mailPage.typeLetterRecepient();
        mailPage.typeLetterTheme();
        mailPage.letterTextArea().sendKeys("Найдено " + letterCountBeforeSend + " писем\\ьма");
        mailPage.clickSendLetterButton();
        mailPage.clickToBackToIncoming();

        driver.navigate().refresh();

        List<WebElement> letterAfterSend = driver.findElements(By.xpath("//span[@title='Simbirsoft theme']"));

        int letterCountAfterSend = letterAfterSend.size();

        Assert.assertNotEquals(letterCountBeforeSend, letterCountAfterSend);

        }
    }


