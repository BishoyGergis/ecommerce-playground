package testCases.addToCartTestCases;

import baseTest.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;


public class AddToCartCounterTest extends BaseTest {
    ProductPage productPage;
    EditCartPage editCartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUpPage()  {
        HomePage homePage= new HomePage(driver);
        homePage.ClickShopByCategoryLink().ClickComponentsLink();

        productPage = new ProductPage(driver);
        editCartPage = new EditCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Feature("Cart Management")
    @Story("Add multiple products to cart and verify the item count")
    @Description("Verify that adding multiple products to the cart updates the cart item count correctly")
    @Test
    public void addToCartCounter () throws InterruptedException {
        Allure.step("Click the List View button and select products by index");
        productPage
                .clickListViewButton()
                .clickProductByIndex(0)
                .clickProductByIndex(0)
                .clickProductByIndex(1);
        Thread.sleep(2000);

        Allure.step("Verify the cart item count after adding items");
        System.out.println("Cart Item Count should be  : " + productPage.getCartItemCounter());
        Assert.assertEquals(productPage.getCartItemCounter(), "3");
    }

}
