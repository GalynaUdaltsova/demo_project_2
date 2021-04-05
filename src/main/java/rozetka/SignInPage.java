package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage{
    public static final String CABINET_PAGE_URL = "ROZETKA — Особисті дані | Особистий кабінет";
    private static final By GOOGLE = new By.ByXPath("//button[contains(text(), ' Google')]");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void checkPage() {

    }

    public void login() {
        driver.findElement(GOOGLE).click();
    }
}
