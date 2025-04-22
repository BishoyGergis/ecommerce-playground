package testCases.checkoutTestCases;

import baseTest.BaseTest;
import io.qameta.allure.Description;
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

    @Description("Checkout with out of stock products ")
    @Test
    public void addToCartScenario () throws InterruptedException {
        productPage.clickListViewButton().clickOutStockFilterCheckbox();
        Thread.sleep(2000);
        productPage.clickProductByIndex(1)
                .clickClosePopupButton();
        productPage.clickOutStockFilterCheckbox().clickInStockFilterCheckbox();
        Thread.sleep(2000);
        productPage.clickProductByIndex(3)
                .clickClosePopupButton()
                .clickCartIcon()
                .clickSidebarMenuEditCartButton();
        editCartPage.removeOutOfStockItems().clickCheckoutButton();
        checkoutPage
                .clickAgreeCheckoutBox()
                .clickCheckoutButton();
        ConfirmOrderPage.clickConfirmOrderButton();
        Assert.assertTrue(ConfirmOrderPage.getOrderPlacedTitle().contains("Your order has been placed!"));
    }
}
