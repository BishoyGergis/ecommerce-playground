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

public class CheckoutAsGuestTest extends BaseTest {
    ProductPage productPage;
    EditCartPage editCartPage;
    CheckoutPage checkoutPage;
    ConfirmOrderPage ConfirmOrderPage;



    @BeforeMethod
    public void setUpPage() {
        HomePage homePage= new HomePage(driver);
        homePage.ClickShopByCategoryLink();
        homePage.ClickComponentsLink();

        productPage = new ProductPage(driver);
        editCartPage = new EditCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        ConfirmOrderPage = new ConfirmOrderPage(driver);
    }

    @Feature("Checkout Process")
    @Story("Guest user places an order successfully")
    @Description("Verify that a guest user can add an in-stock product to the cart and complete the checkout process with valid information")
    @Test
    public void checkOutAsGuest () throws InterruptedException {
        Allure.step("Select product, add to cart, and proceed to checkout");
        productPage.clickListViewButton()
                .clickInStockFilterCheckbox();
        Thread.sleep(3000);
        productPage.clickProductByIndex(3)
                .clickClosePopupButton()
                .clickCartIcon()
                .clickSidebarMenuEditCartButton();
        editCartPage.clickCheckoutButton();

        Allure.step("Fill out personal, shipping, and payment details during checkout");
        checkoutPage.clickGuestCheckoutRadioButton()
                .enterFirstName("Bisho")
                .enterlasstName("Gergis")
                .enterEmail("gg@gmail.com")
                .enterAddress1("ssasdas")
                .enterTelephone("33123123")
                .enterCity("Alex")
                .enterPostcode("03")
                .enterCompany("iti")
                .selectCountryByName("Egypt");
        Thread.sleep(3000);

        Allure.step("Agree to terms and complete the order");
        checkoutPage.selectRegionByIndex(1)
                .clickAgreeCheckoutBox()
                .clickCheckoutButton();
        ConfirmOrderPage.clickConfirmOrderButton();

        Allure.step("Verify order confirmation message");
        Assert.assertTrue(ConfirmOrderPage.getOrderPlacedTitle().contains("Your order has been placed!"));
    }

}
