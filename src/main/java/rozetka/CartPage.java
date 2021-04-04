package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    public static final By CART_ACTION_BUTTON = new By.ByXPath("//button[contains(@id,'cartProductActions')]");
    public static final By TRASH_ICON_BUTTON = new By.ByXPath("//li[@class='context-menu__item']");
    public static final By EMPTY_CART_TITLE = new By.ByXPath("//h4[@class='cart-dummy__heading']");

    protected WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteProductsFromCart(int count) {
        for (int i = 0; i < count; i++) {
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(CART_ACTION_BUTTON));
            driver.findElement(CART_ACTION_BUTTON).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(TRASH_ICON_BUTTON));
            driver.findElement(TRASH_ICON_BUTTON).click();
        }
    }

    public boolean isCartEmpty() {
        return driver.findElement(EMPTY_CART_TITLE).isDisplayed();
    }
}
