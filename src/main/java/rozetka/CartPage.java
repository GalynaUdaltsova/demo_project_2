package rozetka;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {
    public static final By EMPTY_CART_TITLE = new By.ByXPath("//h4[@class='cart-dummy__heading']");
    public static final By CART_HEADER = new By.ByXPath("//div[@class='modal__header']//*[@class='modal__heading'][contains(text(),'Кошик ')]");
    private static final By CART_ACTION_BTN = new By.ByXPath("//button[contains(@id,'cartProductActions')]");
    private static final By DEL_BTN = new By.ByXPath("//ul[contains(@id,'cartProductActions')]//button[contains(text(),'Видалити')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void checkPage() {
        Assert.assertTrue(driver.findElement(CART_HEADER).isDisplayed());
    }

    @Step("Delete products from cart")
    public void deleteProductsFromCart(int count) {
        for (int i = 0; i < count; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(CART_ACTION_BTN));
            driver.findElement(CART_ACTION_BTN).click();
            wait.until(ExpectedConditions.elementToBeClickable(DEL_BTN));
            driver.findElement(DEL_BTN).click();
        }
    }

    public boolean isCartEmpty() {
        return driver.findElement(EMPTY_CART_TITLE).isDisplayed();
    }
}
