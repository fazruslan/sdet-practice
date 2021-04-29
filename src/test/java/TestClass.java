import com.test.config.PropertiesFile;
import com.test.model.pages.MailAuthorizationPage;
import com.test.model.pages.MailPage;
import com.test.utils.Webdriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;


public class TestClass {

    WebDriver driver = Webdriver.getChromeDriver();
    MailPage mailPage = PageFactory.initElements(driver, MailPage.class);
    MailAuthorizationPage mailAuthorizationPage = PageFactory.initElements(driver, MailAuthorizationPage.class);
    PropertiesFile prop = new PropertiesFile();


    @Before
    public void setUp() {
        driver.get(mailPage.pageUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void authorization() {
        mailPage.clickMailSignInButton();
        mailAuthorizationPage.typeLogin();
        mailPage.clickAuthorizationSignInButton();
        mailAuthorizationPage.typePassword();
        mailPage.clickAuthorizationSignInButton();
        mailPage.clickUserPicture();
        String currentUserLogin = mailPage.receiveUserLogin();

        Assert.assertEquals(prop.userLogin, currentUserLogin);


    }

    @Test
    public void sendLetterAndCheckCount() {
        mailPage.clickMailSignInButton();
        mailAuthorizationPage.typeLogin();
        mailPage.clickAuthorizationSignInButton();
        mailAuthorizationPage.typePassword();
        mailPage.clickAuthorizationSignInButton();
        mailPage.clickWriteLetterButton();
        mailPage.typeLetterRecepient();
        mailPage.typeLetterTheme();
        mailPage.typeLetterContent();
        int beforeSend = mailPage.calculateLetterCount();
        mailPage.clickSendLetterButton();
        mailPage.clickBackToIncoming();
        driver.navigate().refresh();
        int afterSend = mailPage.calculateLetterCount();

        Assert.assertNotEquals(beforeSend, afterSend);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
