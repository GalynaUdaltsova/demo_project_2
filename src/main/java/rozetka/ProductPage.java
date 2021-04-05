package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage{
    private static final By BUY_BUTTON = new By.ByXPath("//button[@aria-label='Купити']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void checkPage() {

    }

    public void byProduct() {
        try {
            WebElement element = driver.findElement(BUY_BUTTON);
            element.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement element = driver.findElement(BUY_BUTTON);
            element.click();
        }
    }
}
