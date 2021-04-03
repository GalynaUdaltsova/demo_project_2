import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rozetka.HomePage;
import rozetka.ProductPage;
import rozetka.SearchResultsPage;

public class SearchResultsTest extends BaseTest {

    @DataProvider(name = "search")
    public Object[][] search() {
        return new Object[][] {
                { "Телевізор LG"},
                { "Телевізор Samsung"},
                { "Телефон Samsung"},
                { "Телефон IPhone"},
        };
    }

    @Test(dataProvider = "search")
    public void addToCart(String product) {
        HomePage homePage = new HomePage(driver);
        homePage.searchProductByCriteria(product);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.openProductCard();
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
    }
}
