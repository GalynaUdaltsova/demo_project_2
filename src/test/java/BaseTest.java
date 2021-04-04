import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import rozetka.HomePage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static org.codehaus.plexus.util.FileUtils.copyFile;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver");
    }

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(HomePage.HOME_PAGE_URL);
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenshot(ITestResult result) {
        //!result.isSuccess()
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            copyFile(scrFile, new File(result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
