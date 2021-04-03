package rozetka;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {
    protected WebDriver driver;
    private String pageTitle;

    public BasePage(WebDriver driver, String pageTitle) {
        this.driver = driver;
        this.pageTitle = pageTitle;
    }

    public void checkPage() {
        String title = driver.getTitle();
        Assert.assertEquals(title, pageTitle);
    }
}
