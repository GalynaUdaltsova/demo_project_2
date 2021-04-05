import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rozetka.HomePage;
import rozetka.SearchResultsPage;

public class HomePageTest extends BaseTest{


    @DataProvider(name = "search")
    public Object[][] search() {
        return new Object[][] {
                { "Apple iPhone 11"},
                { "Xiaomi Redmi 9A"},
                { "Samsung Galaxy"},
                { "MacBook"},
                { "abcdefghijklmnopqrstuvwxyz"},
        };
    }

    @Test(dataProvider = "search")
    public void search(String item) throws SkipException {
        HomePage homePage = new HomePage(driver);
        homePage.showProductByCriteria(item);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        String titleFirst = searchResultsPage.getFirstResultTitle();
        Assert.assertTrue(titleFirst.contains(item));
    }
}
