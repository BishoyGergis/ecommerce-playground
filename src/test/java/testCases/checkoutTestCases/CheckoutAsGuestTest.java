package testCases.checkoutTestCases;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutAsGuestTest extends BaseTest {
    ProductPage productPage;
    EditCartPage editCartPage;
    CheckoutPage checkoutPage;



    @BeforeMethod
    public void setUpPage() {
        HomePage homePage= new HomePage(driver);
        homePage.ClickShopByCategoryLink();
        homePage.ClickComponentsLink();

        productPage = new ProductPage(driver);
        editCartPage = new EditCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Description("Checkout Scenario ")
    @Test
    public void addToCartScenario () throws InterruptedException {
        productPage.clickListViewButton()
                .clickInStockFilterCheckbox();
        Thread.sleep(2000);
        productPage.clickProductByIndex(1)
                .clickClosePopupButton()
                .clickCartIcon()
                .clickSidebarMenuEditCartButton();
        editCartPage.clickCheckoutButton();
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
        Thread.sleep(2000);

        checkoutPage.selectRegionByIndex(1)
                .clickAgreeCheckoutBox()
                .clickCheckoutButton();
    }

}
