import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartTest extends BaseTest {

    private By cartBtn = new By.ByXPath("//rz-cart/button");
    private By cartHeader = new By.ByXPath("//h3[@class='modal__heading'][contains(text(), 'Кошик')]");
    private By itemTitle = new By.ByXPath("//div[@class='goods-tile__inner']//span[@class='goods-tile__title']");
    private By buyBtn = new By.ByXPath("//div[@class='goods-tile__inner']//button[@aria-label='Купити']");
    private By cartProd = new By.ByXPath("//div[@class='cart-product']");
    private By titleInCart = new By.ByXPath("//div[@class='cart-product']//a[@class='cart-product__title']");
    private final int NUMBER_OF_ITEMS = 5; //how many items we want to add to the cart or remove from the cart

//    @Test
//    public void checkAddToCartOneItem() {
//        driver.get("https://rozetka.com.ua/ua/notebooks/c80004/");
//        WebElement itemTitleEl = driver.findElement(itemTitle);
//        String title = itemTitleEl.getText();
//        new WebDriverWait(driver, 20)
//                .until(ExpectedConditions.elementToBeClickable(buyBtn)).click();
//        driver.findElement(cartBtn).click();
//        driver.findElement(cartProd);
//        WebElement titleInCartEl = driver.findElement(titleInCart);
//        String itemTitleInCart = titleInCartEl.getText();
//        driver.findElement(titleInCart);
//        Assert.assertEquals(title, itemTitleInCart);
//    }

    @Test
    public void checkAddToCart() {
        driver.get("https://rozetka.com.ua/ua/notebooks/c80004/");
        List<WebElement> elTitles = driver.findElements(itemTitle);
        List<String> itemsTitles = new ArrayList<>();
        //Adding items titles to the list to compare them later with those in the cart:
        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            itemsTitles.add(elTitles.get(i).getText());
        }
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buyBtn));
        List<WebElement> buyBtns = driver.findElements(buyBtn);
        //Adding items to the cart:
        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            buyBtns.get(i).click();
        }
        driver.findElement(cartBtn).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(cartHeader));
        driver.findElement(cartHeader);
        List<WebElement> elTitlesInCart = driver.findElements(titleInCart);
        List<String> itemsTitlesInCart = new ArrayList<>();
        for (WebElement el : elTitlesInCart) {
            itemsTitlesInCart.add(el.getText());
        }
        //reverse order for items in the cart to compare with item titles (itemsTitles)
        Collections.reverse(itemsTitlesInCart);
        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            Assert.assertEquals(itemsTitles.get(i), itemsTitlesInCart.get(i));
        }
    }

    @Test
    public void checkRemoveFromCart() {
        driver.get("https://rozetka.com.ua/ua/notebooks/c80004/");
        List<WebElement> buyBtns = driver.findElements(buyBtn);
        //Adding items to the cart:
        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            buyBtns.get(i).click();
        }
        driver.findElement(cartBtn).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(cartHeader));
        driver.findElement(cartHeader);
        //removing items from the cart
        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            By cartActionBtn = new By.ByXPath("//button[contains(@id,'cartProductActions')]");
            By delBtn = new By.ByXPath("//ul[contains(@id,'cartProductActions')]//button[contains(text(),'Видалити')]");
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(cartActionBtn));
            driver.findElement(cartActionBtn).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(delBtn));
            driver.findElement(delBtn).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        driver.findElement(By.xpath("//div[@class='cart-dummy']"));
        //check that cart is empty:
        driver.findElement(By.xpath("//*[@class='cart-dummy__heading'][contains(text(), 'Кошик порожній')]"));
    }
}
