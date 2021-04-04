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
        homePage.showProductByCriteria("Xiaomi");
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        List<String> itemsTitles = searchResultsPage.getItems(3);
        searchResultsPage.addProductsToCart(3);
        searchResultsPage.openCart();
        List<String> itemsTitlesInCart = searchResultsPage.getCartProductTitles();
        Collections.reverse(itemsTitlesInCart);
        for (int i = 0; i < itemsTitlesInCart.size(); i++) {
            Assert.assertEquals(itemsTitles.get(i), itemsTitlesInCart.get(i));
        }
    }

    @Test
    public void deleteFromCart() {
        HomePage homePage = new HomePage(driver);
        homePage.showProductByCriteria("Xiaomi");
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.addProductsToCart(1);
        searchResultsPage.openCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.deleteProductsFromCart(1);
        Assert.assertTrue(cartPage.isCartEmpty());
    }
}
