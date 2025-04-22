package testCases.checkoutTestCases;


import baseTest.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;


public class CheckoutWithLogedinUserTest extends BaseTest {
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

    @Description("Checkout Scenario ")
    @Test
    public void addToCartScenario () throws InterruptedException {
        productPage.clickListViewButton().clickInStockFilterCheckbox();
        Thread.sleep(2000);
        productPage.clickProductByIndex(1) // 1=bug , 3 / 4 / 7 / 8 / 9 success
                .clickClosePopupButton()
                .clickCartIcon()
                .clickSidebarMenuEditCartButton();
        editCartPage.clickCheckoutButton();
        checkoutPage.clickAgreeCheckoutBox().clickCheckoutButton();
        ConfirmOrderPage.clickConfirmOrderButton();
        Assert.assertTrue(ConfirmOrderPage.getOrderPlacedTitle().contains("Your order has been placed!"));
    }
}
