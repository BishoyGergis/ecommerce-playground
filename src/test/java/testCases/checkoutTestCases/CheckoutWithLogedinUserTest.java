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

    @Feature("Checkout Process")
    @Story("Registered user completes a quick checkout with in-stock product")
    @Description("Verify that a user can quickly select a product, proceed to checkout, agree to terms, and confirm the order successfully")
    @Test
    public void checkoutWithLogedinUser () throws InterruptedException {
        Allure.step("Select a product by index" );
        productPage.clickListViewButton().clickInStockFilterCheckbox();
        Thread.sleep(4000);
        productPage.clickProductByIndex(3) // 1=bug , 3 / 4 / 7 / 8 / 9 success
                .clickClosePopupButton()
                .clickCartIcon()
                .clickSidebarMenuEditCartButton();

        Allure.step("Proceed to checkout and agree to terms");
        editCartPage.clickCheckoutButton();
        checkoutPage.clickAgreeCheckoutBox().clickCheckoutButton();

        Allure.step("Confirm the order and verify the confirmation message");
        ConfirmOrderPage.clickConfirmOrderButton();
        Assert.assertTrue(ConfirmOrderPage.getOrderPlacedTitle().contains("Your order has been placed!"));
    }
}
