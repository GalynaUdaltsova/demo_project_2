package rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        checkPage();
        wait = new WebDriverWait(driver, 10);
    }

    public abstract void checkPage();
}
