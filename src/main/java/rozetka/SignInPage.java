package rozetka;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInPage extends BasePage {
    public static final String CABINET_PAGE_URL = "ROZETKA — Особисті дані | Особистий кабінет";
    private static final By GOOGLE = new By.ByXPath("//button[contains(text(), ' Google')]");
    private static final By CART_HEADER = new By.ByXPath("//div[@class='modal__header']//*[@class='modal__heading']");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void checkPage() {
        Assert.assertTrue(driver.findElement(CART_HEADER).isDisplayed());
    }

    @Step("Login")
    public void login() {
        driver.findElement(GOOGLE).click();
    }
}
