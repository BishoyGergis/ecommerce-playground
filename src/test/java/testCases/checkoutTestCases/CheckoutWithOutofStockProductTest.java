package testCases.checkoutTestCases;

import baseTest.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutWithOutofStockProductTest extends BaseTest {

    ProductPage productPage;
    EditCartPage editCartPage;
    CheckoutPage checkoutPage;
    LoginPage loginPage;
    ConfirmOrderPage ConfirmOrderPage;



    @BeforeMethod
    public void setUpPage() {
        HomePage homePage= new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.clickLoginSelection();
        loginPage.enterEMailAddress("Bg6@gmail.com")
                .enterPassword("password1")
                .clickLoginButton();
        homePage.ClickShopByCategoryLink();
        homePage.ClickComponentsLink();

        productPage = new ProductPage(driver);
        editCartPage = new EditCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        ConfirmOrderPage = new ConfirmOrderPage(driver);
    }

    @Feature("Checkout Process")
    @Story("Handle out-of-stock items before completing checkout")
    @Description("Verify that the user can filter out-of-stock products, remove them from the cart, and proceed to place an order with in-stock items only")
    @Test
    public void checkoutAfterRemoveOutOfStockItems () throws InterruptedException {
        Allure.step("Apply 'Out of Stock' filter and select a product by index ");
        productPage.clickListViewButton().clickOutStockFilterCheckbox();
        Thread.sleep(2000);
        productPage.clickProductByIndex(1)
                .clickClosePopupButton();

        Allure.step("Remove 'Out of Stock' filter, apply 'In Stock' filter, and select a new product by index");
        productPage.clickOutStockFilterCheckbox().clickInStockFilterCheckbox();
        Thread.sleep(3000);
        productPage.clickProductByIndex(3)
                .clickClosePopupButton()
                .clickCartIcon()
                .clickSidebarMenuEditCartButton();

        Allure.step("Remove out-of-stock items and click the 'Checkout' button");
        editCartPage.removeOutOfStockItems().clickCheckoutButton();

        Allure.step("Agree to terms and proceed with checkout");
        checkoutPage
                .clickAgreeCheckoutBox()
                .clickCheckoutButton();

        Allure.step("Confirm the order and verify the confirmation message");
        ConfirmOrderPage.clickConfirmOrderButton();
        Assert.assertTrue(ConfirmOrderPage.getOrderPlacedTitle().contains("Your order has been placed!"));
    }
}
