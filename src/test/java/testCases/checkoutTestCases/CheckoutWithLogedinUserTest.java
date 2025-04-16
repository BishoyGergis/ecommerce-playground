package testCases.checkoutTestCases;


import baseTest.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;


public class CheckoutWithLogedinUserTest extends BaseTest {
    ProductPage productPage;
    EditCartPage editCartPage;
    CheckoutPage checkoutPage;
    LoginPage loginPage;


    @BeforeMethod
    public void setUpPage() {
        HomePage homePage= new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.clickLoginSelection();
        loginPage.enterEMailAddress("Bg2@gmail.com")
                .enterPassword("password")
                .clickLoginButton();
        homePage.ClickShopByCategoryLink();
        homePage.ClickComponentsLink();

        productPage = new ProductPage(driver);
        editCartPage = new EditCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Description("Checkout Scenario ")
    @Test
    public void addToCartScenario () throws InterruptedException {
        productPage.clickListViewButton().clickInStockFilterCheckbox();
        Thread.sleep(2000);
        productPage.clickProductByIndex(1)
                .clickClosePopupButton()
                .clickCartIcon()
                .clickSidebarMenuEditCartButton();
        editCartPage.clickCheckoutButton();
        checkoutPage.clickAgreeCheckoutBox().clickCheckoutButton();
    }
}
