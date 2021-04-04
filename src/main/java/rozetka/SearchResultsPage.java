package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {
    protected WebDriver driver;

    private By item = By.xpath("//span[@class='goods-tile__title'][1]");private By cartBtn = new By.ByXPath("//rz-cart/button");
    private By cartHeader = new By.ByXPath("//h3[@class='modal__heading'][contains(text(), 'Кошик')]");
    private By itemTitle = new By.ByXPath("//div[@class='goods-tile__inner']//span[@class='goods-tile__title']");
    private By buyBtn = new By.ByXPath("//button[@class='buy-button goods-tile__buy-button']");
    private By cartProd = new By.ByXPath("//div[@class='cart-product']");
    private By titleInCart = new By.ByXPath("//div[@class='cart-product']//a[@class='cart-product__title']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage openProductCard() {
        driver.findElement(item).click();
        return new ProductPage(driver);
    }

    public List<String> findItems(int count) {
        List<WebElement> elTitles = driver.findElements(itemTitle);
        List<String> itemsTitles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            itemsTitles.add(elTitles.get(i).getText());
        }
        System.out.println(itemsTitles);
        return itemsTitles;
    }

    public List<WebElement> clickBtns(int count) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buyBtn));
        List<WebElement> buyBtns = driver.findElements(buyBtn);
        for (int i = 0; i < count; i++) {
            buyBtns.get(i).click();
        }
        return buyBtns;
    }

    public void goToCart() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(cartBtn));
        driver.findElement(cartBtn).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(cartHeader));
        driver.findElement(cartHeader);
    }

    public List<String> findElements() {
        List<WebElement> elTitlesInCart = driver.findElements(titleInCart);
        List<String> itemsTitlesInCart = new ArrayList<>();
        for (WebElement el : elTitlesInCart) {
            itemsTitlesInCart.add(el.getText());
        }
        System.out.println(itemsTitlesInCart);
        return itemsTitlesInCart;
    }

    public int count() {
        ArrayList<WebElement> elements = (ArrayList<WebElement>) driver.findElements(item);
        return elements.toArray().length;
    }
}

