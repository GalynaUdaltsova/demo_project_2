package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{
    public static final By EMPTY_CART_TITLE = new By.ByXPath("//h4[@class='cart-dummy__heading']");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void checkPage() {

    }

    public void deleteProductsFromCart(int count) {
        for (int i = 0; i < count; i++) {
            By cartActionBtn = new By.ByXPath("//button[contains(@id,'cartProductActions')]");
            By delBtn = new By.ByXPath("//ul[contains(@id,'cartProductActions')]//button[contains(text(),'Видалити')]");
            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(cartActionBtn));
            driver.findElement(cartActionBtn).click();
            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(delBtn));
            driver.findElement(delBtn).click();
        }
    }

    public boolean isCartEmpty() {
        return driver.findElement(EMPTY_CART_TITLE).isDisplayed();
    }
}
