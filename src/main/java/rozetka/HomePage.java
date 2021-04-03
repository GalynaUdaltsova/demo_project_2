package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public static final String HOME_PAGE_URL = "https://rozetka.com.ua/ua/";
    private static final String HOME_PAGE_TITLE = "Інтернет-магазин ROZETKA™: офіційний сайт найпопулярнішого " +
            "онлайн-гіпермаркету в Україні";

    private By userIcon = new By.ByXPath("//rz-user/button[contains(@class,'header__button')]");
    private By searchInput = new By.ByXPath("//input[contains(@class, 'search-form__input')]");
    private By searchSubmit = new By.ByXPath("//button[contains(@class, 'search-form__submit')]");
    private By burgerMenu = new By.ByXPath("//button[@aria-label='Відкрити меню']");
    private By personalInfo = new By.ByXPath("//a[@href='https://rozetka.com.ua/ua/cabinet/personal-information/']");

    public HomePage(WebDriver driver) {
        super(driver, HOME_PAGE_TITLE);
    }

    public void login(){
        driver.get(HOME_PAGE_URL);
        driver.findElement(userIcon).click();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.login();
    }

    public void enterToCabinet(){
        driver.findElement(burgerMenu).click();
        driver.findElement(personalInfo).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='cabinet__heading']")));
    }

    public SearchResultsPage searchProductByCriteria(String criteriaValue) {
        driver.findElement(searchInput).sendKeys(criteriaValue);
        driver.findElement(searchSubmit).click();
        return new SearchResultsPage(driver);
    }
}
