package testCases.addToCartTestCases;

import baseTest.BaseTest;
import io.qameta.allure.Description;
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

    @Description("Add to Cart Scenario")
    @Test
    public void addToCartScenario () throws InterruptedException {
        productPage
                .clickListViewButton()
                .clickProductByIndex(0)
                .clickProductByIndex(0)
                .clickProductByIndex(1);
        System.out.println("Cart Item Count should be 0 : " + productPage.getCartItemCounter());
        Thread.sleep(2000);

        System.out.println("Cart Item Count should be  : " + productPage.getCartItemCounter());
        Assert.assertEquals(productPage.getCartItemCounter(), "3");
    }

}
