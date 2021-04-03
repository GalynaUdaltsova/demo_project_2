import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {
    protected WebDriver driver;

    private String pageUrl;
    private String pageTitle;

    public BasePage(WebDriver driver, String pageUrl, String pageTitle) {
        this.driver = driver;
        this.pageUrl = pageUrl;
        this.pageTitle = pageTitle;
    }

    public void checkValidTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, pageTitle);
    }
}
