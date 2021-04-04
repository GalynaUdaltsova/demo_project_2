import org.testng.Assert;
import org.testng.annotations.Test;
import rozetka.CartPage;
import rozetka.HomePage;
import rozetka.SearchResultsPage;
import java.util.Collections;
import java.util.List;

public class CartTest extends BaseTest {

    @Test
    public void addToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.searchProductByCriteria("Xiaomi");
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        List<String> itemsTitles = searchResultsPage.findItems(5);
        searchResultsPage.clickBtns(5);
        searchResultsPage.goToCart();
        List<String> itemsTitlesInCart = searchResultsPage.findElements();
        Collections.reverse(itemsTitlesInCart);
        for (int i = 0; i < itemsTitlesInCart.toArray().length; i++) {
            Assert.assertEquals(itemsTitles.get(i), itemsTitlesInCart.get(i));
        }
    }

    @Test
    public void deleteFromCart() {
        HomePage homePage = new HomePage(driver);
        homePage.searchProductByCriteria("Xiaomi");
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.clickBtns(1);
        searchResultsPage.goToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.del(1);
        Assert.assertTrue(cartPage.emptyCart());
    }
}
