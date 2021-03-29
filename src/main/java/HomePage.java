import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;

    private By userIcon = new By.ByXPath("//rz-user/button[contains(@class,'header__button')]");
    private By searchInput = new By.ByXPath("//input[contains(@class, 'search-form__input')]");
    private By searchSubmit = new By.ByXPath("//button[contains(@class, 'search-form__submit')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(String email, String password){
        driver.findElement(userIcon).click();
        SignInPage signInPage = new SignInPage(driver);
        return signInPage.login(email, password);
    }

    public SearchResultsPage searchProductByCriteria(String criteriaValue) {
        driver.findElement(searchInput).sendKeys(criteriaValue);
        driver.findElement(searchSubmit).click();
        return new SearchResultsPage(driver);
    }
}
