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
        driver.get(prop.pageUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void authorization() {
        mailPage.clickMailStartSignInButton();
        mailAuthorizationPage.inputLogin(prop.userLogin);
        mailPage.clickAuthorizationSignInButton();
        mailAuthorizationPage.inputPassword(prop.userPass);
        mailPage.clickAuthorizationSignInButton();
        mailPage.clickUserPicture();
        String currentUserLogin = mailPage.receiveUserLogin();

        Assert.assertEquals(prop.userLogin, currentUserLogin);
    }

    @Test
    public void sendLetterAndCheckCount() {
        mailPage.clickMailStartSignInButton();
        mailAuthorizationPage.inputLogin(prop.userLogin);
        mailPage.clickAuthorizationSignInButton();
        mailAuthorizationPage.inputPassword(prop.userPass);
        mailPage.clickAuthorizationSignInButton();
        int letterCount = mailPage.calculateLetterCount();
        mailPage.clickWriteLetterButton();
        mailPage.inputLetterRecepient(prop.userEmail);
        mailPage.typeLetterTheme(mailPage.letterTheme);
        mailPage.typeLetterContent();
        Assert.assertEquals(letterCount, letterCount);
        mailPage.clickSendLetterButton();
        mailPage.clickBackToIncoming();
        driver.navigate().refresh();
        int afterSend = mailPage.calculateLetterCount();

        Assert.assertNotEquals(letterCount, afterSend);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
