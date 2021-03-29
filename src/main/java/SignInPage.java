import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    protected WebDriver driver;

    private By emailInput = new By.ByXPath("//*[@id='auth_email']");
    private By passwordInput = new By.ByXPath("//*[@id='auth_pass']");
    private By submit = new By.ByXPath("//button[contains(@class, 'auth-modal__submit')]");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(String email, String password){
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submit).click();
        return new HomePage(driver);
    }
}
