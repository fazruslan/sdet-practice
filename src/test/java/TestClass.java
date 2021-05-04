import com.test.config.PropertiesFile;
import com.test.model.pages.MailAuthorizationPage;
import com.test.model.pages.MailPage;
import com.test.utils.Webdriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;


public class TestClass {

    WebDriver driver = Webdriver.getChromeDriver();
    MailPage mailPage = new MailPage(driver);
    MailAuthorizationPage mailAuthorizationPage = new MailAuthorizationPage(driver);
    PropertiesFile prop = new PropertiesFile();


    @Before
    public void setUp() {
        driver.get(mailPage.pageUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void authorization() {
        mailPage.clickMailStartSignInButton(mailPage.mailStartPageSignInButton());
        mailAuthorizationPage.inputLogin(prop.userLogin);
        mailPage.clickAuthorizationSignInButton(mailPage.authorizationSignInButton());
        mailAuthorizationPage.inputPassword(prop.userPass);
        mailPage.clickAuthorizationSignInButton(mailPage.authorizationSignInButton());
        mailPage.clickUserPicture(mailPage.userPicture());
        String currentUserLogin = mailPage.receiveUserLogin();

        Assert.assertEquals(prop.userLogin, currentUserLogin);


    }

    @Test
    public void sendLetterAndCheckCount() {
        mailPage.clickMailStartSignInButton(mailPage.mailStartPageSignInButton());
        mailAuthorizationPage.inputLogin(prop.userLogin);
        mailPage.clickAuthorizationSignInButton(mailPage.authorizationSignInButton());
        mailAuthorizationPage.inputPassword(prop.userPass);
        mailPage.clickAuthorizationSignInButton(mailPage.authorizationSignInButton());
        mailPage.clickWriteLetterButton(mailPage.writeLetterButton());
        mailPage.inputLetterRecepient(prop.userEmail);
        mailPage.typeLetterTheme(mailPage.letterTheme);
        mailPage.typeLetterContent(mailPage.textArea());
        int beforeSend = mailPage.calculateLetterCount();
        Assert.assertEquals(beforeSend, beforeSend);
        mailPage.clickSendLetterButton(mailPage.sendButton());
        mailPage.clickBackToIncoming(mailPage.backToIncoming());
        driver.navigate().refresh();
        int afterSend = mailPage.calculateLetterCount();

        Assert.assertNotEquals(beforeSend, afterSend);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
