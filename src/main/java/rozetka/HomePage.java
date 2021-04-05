package rozetka;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {
    public static final String HOME_PAGE_URL = "https://rozetka.com.ua/ua/";
    private static final String HOME_PAGE_TITLE = "Інтернет-магазин ROZETKA™: офіційний сайт найпопулярнішого " +
            "онлайн-гіпермаркету в Україні";
    private static final By USER_ICON = new By.ByXPath("//rz-user/button[contains(@class,'header__button')]");
    private static final By SEARCH_INPUT = new By.ByXPath("//input[contains(@class, 'search-form__input')]");
    private static final By SEARCH_SUBMIT = new By.ByXPath("//button[contains(@class, 'search-form__submit')]");
    private static final By BURGER_MENU = new By.ByXPath("//button[@aria-label='Відкрити меню']");
    private static final By PERSONAL_INFO = new By.ByXPath("//a[@href='https://rozetka.com.ua/ua/cabinet/personal-information/']");
    private static final By PERSONAL_DATA = new By.ByXPath("//h1[@class='cabinet__heading']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void checkPage() {
        String title = driver.getTitle();
        Assert.assertEquals(title, HOME_PAGE_TITLE);
    }

    @Step("Login")
    public void login() {
        driver.get(HOME_PAGE_URL);
        driver.findElement(USER_ICON).click();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.login();
    }

    @Step("Enter to cabinet")
    public void enterToCabinet() {
        driver.findElement(BURGER_MENU).click();
        driver.findElement(PERSONAL_INFO).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(PERSONAL_DATA));
    }

    @Step("Show product by criteria")
    public void showProductByCriteria(String criteriaValue) {
        driver.findElement(SEARCH_INPUT).sendKeys(criteriaValue);
        driver.findElement(SEARCH_SUBMIT).click();
    }
}
