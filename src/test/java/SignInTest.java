import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    @DataProvider(name = "login")
    public Object[][] login() {
        return new Object[][] {
                { "example1990@ukr.net", "Password1"},
        };
    }

    @Test(dataProvider = "login")
    public void checkLoginToSite(String email, String password) {
        HomePage homePage = new HomePage(driver);
        homePage.login(email, password);
    }
}
