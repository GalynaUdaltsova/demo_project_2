package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    protected WebDriver driver;

    private By cartBtn = new By.ByXPath("//rz-cart/button");
    private By cartHeader = new By.ByXPath("//h3[@class='modal__heading'][contains(text(), 'Кошик')]");
    private By itemTitle = new By.ByXPath("//div[@class='goods-tile__inner']//span[@class='goods-tile__title']");
    private By buyBtn = new By.ByXPath("//div[@class='goods-tile__inner']//button[@aria-label='Купити']");
    private By cartProd = new By.ByXPath("//div[@class='cart-product']");
    private By titleInCart = new By.ByXPath("//div[@class='cart-product']//a[@class='cart-product__title']");
    private final int NUMBER_OF_ITEMS = 5; //how many items we want to add to the cart or remove from the cart
    By cartActionBtn = new By.ByXPath("//button[contains(@id,'cartProductActions')]");
    By trashIcon = new By.ByXPath("//li[@class='context-menu__item']");
    By delBtn = new By.ByXPath("//button[@class='button button--white button--small context-menu__toggle']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void del(int count) {
        for (int i = 0; i < count; i++) {
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(cartActionBtn));
            driver.findElement(cartActionBtn).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(trashIcon));
            driver.findElement(trashIcon).click();
        }
    }

    public boolean emptyCart() {
        return driver.findElement(By.xpath("//h4[@class='cart-dummy__heading']")).isDisplayed();
    }
}
