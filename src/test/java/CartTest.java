import org.testng.Assert;
import org.testng.annotations.Test;
import rozetka.CartPage;
import rozetka.HomePage;
import rozetka.SearchResultsPage;
import java.util.Collections;
import java.util.List;

public class CartTest extends BaseTest {

    private static final int COUNT_OF_ITEMS_TO_ADD = 3;
    private static final int COUNT_OF_ITEMS_TO_DELETE = 1;
    @Test
    public void addToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.showProductByCriteria("Xiaomi");
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        List<String> itemsTitles = searchResultsPage.getItems(COUNT_OF_ITEMS_TO_ADD);
        searchResultsPage.addProductsToCart(COUNT_OF_ITEMS_TO_ADD);
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
        searchResultsPage.addProductsToCart(COUNT_OF_ITEMS_TO_DELETE);
        searchResultsPage.openCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.deleteProductsFromCart(COUNT_OF_ITEMS_TO_DELETE);
        Assert.assertTrue(cartPage.isCartEmpty());
    }
}
