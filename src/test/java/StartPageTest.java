import com.sun.org.glassfish.external.probe.provider.annotations.ProbeListener;
import com.test.model.pages.MailAuthorizationPage;
import com.test.model.pages.YandexStartPage;
import com.test.utils.Webdriver;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;



public class StartPageTest {

    WebDriver driver = Webdriver.getChromeDriver();
    YandexStartPage yandexStartPage = new YandexStartPage(driver);
    MailAuthorizationPage mailAuthorizationPage = new MailAuthorizationPage(driver);

    @Before
    public void setUp() {
        driver.get(yandexStartPage.pageUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void authorization() {
        yandexStartPage.clickSignInButton();
        mailAuthorizationPage.typeLogin();
        mailAuthorizationPage.clickAuthorizationButton();
        mailAuthorizationPage.typePassword();
        mailAuthorizationPage.clickAuthorizationButton();

        String currentUserInfo = yandexStartPage.userInfo().getText();
        Assert.assertEquals(mailAuthorizationPage.userLogin, currentUserInfo);

        Assert.assertEquals(mailAuthorizationPage.userLogin, currentUserInfo);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
