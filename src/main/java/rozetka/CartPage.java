package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    protected WebDriver driver;

    private By cartBtn = new By.ByXPath("//rz-cart/button");
    private By cartHeader = new By.ByXPath("//h3[@class='modal__heading'][contains(text(), 'Кошик')]");
    private By itemTitle = new By.ByXPath("//div[@class='goods-tile__inner']//span[@class='goods-tile__title']");
    private By buyBtn = new By.ByXPath("//div[@class='goods-tile__inner']//button[@aria-label='Купити']");
    private By cartProd = new By.ByXPath("//div[@class='cart-product']");
    private By titleInCart = new By.ByXPath("//div[@class='cart-product']//a[@class='cart-product__title']");
    private final int NUMBER_OF_ITEMS = 5; //how many items we want to add to the cart or remove from the cart

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
}
