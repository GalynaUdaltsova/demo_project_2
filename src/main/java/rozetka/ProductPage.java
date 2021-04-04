package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rozetka.CartPage;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    protected WebDriver driver;

    private By buyButton = new By.ByXPath("//button[@aria-label='Купити']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage addToCart() {
        try{
            WebElement element = driver.findElement(buyButton);
            element.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement element = driver.findElement(buyButton);
            element.click();
        }
        return new CartPage(driver);
    }
}
