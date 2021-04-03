import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rozetka.HomePage;

public class HomePageTest extends BaseTest{

    private By titleFirstItem = By.xpath("//span[@class='goods-tile__title'][1]");

    @DataProvider(name = "search")
    public Object[][] search() {
        return new Object[][] {
                { "Apple iPhone 11"},
                { "Xiaomi Redmi 9A"},
                { "Samsung Galaxy"},
                { "Зеркало для макияжа Xiaomi"},
                { "Набор инструментов"},
        };
    }

    @Test(dataProvider = "search")
    public void search(String item){
        HomePage homePage = new HomePage(driver);
        homePage.searchProductByCriteria(item);
        String titleFirst = driver.findElement(titleFirstItem).getText();
        Assert.assertTrue(titleFirst.contains(item));
    }
}
