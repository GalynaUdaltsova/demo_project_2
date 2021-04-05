package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage{

    private static final By ITEM = By.xpath("//span[@class='goods-tile__title'][1]");
    private static final By CART_BUTTON = new By.ByXPath("//rz-cart/button");
    private static final By CART_HEADER = new By.ByXPath("//h3[@class='modal__heading'][contains(text(), 'Кошик')]");
    private static final By ITEM_TITLE = new By.ByXPath("//div[@class='goods-tile__inner']//span[@class='goods-tile__title']");
    private static final By ADD_TO_CART_BUTTON = new By.ByXPath("//button[@class='buy-button goods-tile__buy-button']");
    private static final By TITLE_IN_CART = new By.ByXPath("//div[@class='cart-product']//a[@class='cart-product__title']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void openProductCard() {
        driver.findElement(ITEM).click();
    }

    public List<String> getItems(int count) {
        List<WebElement> elements = driver.findElements(ITEM_TITLE);
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            titles.add(elements.get(i).getText());
        }
        return titles;
    }

    public void addProductsToCart(int count) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BUTTON));
        List<WebElement> addProductToCartElements = driver.findElements(ADD_TO_CART_BUTTON);
        for (int i = 0; i < count; i++) {
            addProductToCartElements.get(i).click();
        }
    }

    public void openCart() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(CART_BUTTON));
        driver.findElement(CART_BUTTON).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(CART_HEADER));
        driver.findElement(CART_HEADER);
    }

    public List<String> getCartProductTitles() {
        List<WebElement> elements = driver.findElements(TITLE_IN_CART);
        List<String> titles = new ArrayList<>();
        for (WebElement element : elements) {
            titles.add(element.getText());
        }
        return titles;
    }

    public int itemsCount() {
        return driver.findElements(ITEM).size();
    }

    @Override
    public void checkPage() {

    }
}

