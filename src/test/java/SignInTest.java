import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    @DataProvider(name = "login")
    public Object[][] login() {
        return new Object[][] {
                { "ivonnaivanovatest@gmail.com", "Password1#"},
        };
    }

    @Test(dataProvider = "login")
    public void checkLoginWithValidCredentials(String email, String password) {
        GooglePage googlePage = new GooglePage(driver);
        googlePage.loginToTheGoogleAccount(email, password);
        HomePage homePage = new HomePage(driver);
        homePage.login();
        String title = driver.getTitle();
        Assert.assertEquals(title, SignInPage.CABINET_PAGE_URL);
    }

    @DataProvider(name = "invalidLogin")
    public Object[][] InvalidLogin() {
        return new Object[][] {
                { "ivonnaivanova@gmail.com", "Password1#"},
        };
    }

    @Test(dataProvider = "invalidLogin")
    public void checkLoginWithInValidCredentials(String email, String password) {
        GooglePage googlePage = new GooglePage(driver);
        googlePage.loginToTheGoogleAccount(email, password);
        HomePage homePage = new HomePage(driver);
        homePage.login();
        String title = driver.getTitle();
        Assert.assertEquals(title, SignInPage.CABINET_PAGE_URL);
    }
}
