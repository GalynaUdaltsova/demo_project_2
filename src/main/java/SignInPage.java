import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    protected WebDriver driver;

    private By google = new By.ByXPath("//button[contains(text(), ' Google')]");

    public static final String CABINET_PAGE_URL = "ROZETKA — Особисті дані | Особистий кабінет";

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        driver.findElement(google).click();
    }
}
