package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    public static final String CABINET_PAGE_URL = "ROZETKA — Особисті дані | Особистий кабінет";
    private static final By GOOGLE = new By.ByXPath("//button[contains(text(), ' Google')]");

    protected WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        driver.findElement(GOOGLE).click();
    }
}
