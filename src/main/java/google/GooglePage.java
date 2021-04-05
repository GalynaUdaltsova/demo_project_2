package google;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
    private static final String GOOGLE_URL = "https://accounts.google.com/signin/v2/identifier?hl=en&passive=true&continue=" +
            "https%3A%2F%2Fwww.google.com%2F&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
    private static final By INPUT_EMAIL = new By.ByXPath("//input[@type='email']");
    private static final By INPUT_PASSWORD = new By.ByXPath("//input[@type='password']");

    protected WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login to the Google account")
    public void loginToTheGoogleAccount(String email, String password) {
        driver.get(GOOGLE_URL);
        WebElement element1 = driver.findElement(INPUT_EMAIL);
        element1.sendKeys(email, Keys.ENTER);
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(INPUT_PASSWORD))
                .sendKeys(password, Keys.ENTER);
    }
}
