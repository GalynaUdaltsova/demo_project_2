package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    public static final String CABINET_PAGE_URL = "ROZETKA — Особисті дані | Особистий кабінет";

    protected WebDriver driver;
    private By google = new By.ByXPath("//button[contains(text(), ' Google')]");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        driver.findElement(google).click();
    }
}
