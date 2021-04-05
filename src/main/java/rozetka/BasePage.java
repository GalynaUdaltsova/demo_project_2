package rozetka;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        checkPage();
    }

    public abstract void checkPage();
}
