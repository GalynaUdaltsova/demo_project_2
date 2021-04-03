import google.GooglePage;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.Test;
import rozetka.HomePage;
import rozetka.SignInPage;

public class SignInTest extends BaseTest {

    @Test
    public void checkLoginWithValidCredentials() {
        GooglePage googlePage = new GooglePage(driver);
        googlePage.loginToTheGoogleAccount("ivonnaivanovatest@gmail.com", "Password1#");
        HomePage homePage = new HomePage(driver);
        homePage.login();
        homePage.enterToCabinet();
        String title = driver.getTitle();
        Assert.assertEquals(title, SignInPage.CABINET_PAGE_URL);
    }

    @Test(expectedExceptions = ElementClickInterceptedException.class)
    public void checkLoginWithoutGoogleCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.login();
        homePage.enterToCabinet();
    }
}
