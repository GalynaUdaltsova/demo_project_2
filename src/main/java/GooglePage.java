import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
    private static final String GOOGLE_URL = "https://accounts.google.com/signin/v2/identifier?hl=en&passive=true&continue=" +
            "https%3A%2F%2Fwww.google.com%2F&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
    private static final By inputEmail = new By.ByXPath("//input[@type='email']");
    private static final By inputPassword = new By.ByXPath("//input[@type='password']");

    protected WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToTheGoogleAccount(String email, String password) {
        driver.get(GOOGLE_URL);
        WebElement element1 = driver.findElement(inputEmail);
        element1.sendKeys(email, Keys.ENTER);
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(inputPassword))
                .sendKeys(password, Keys.ENTER);
    }
}
