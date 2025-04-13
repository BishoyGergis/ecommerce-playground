package testCases;


import baseTest.BaseTest;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.BuyingItem;


public class CheckoutTest extends BaseTest {
    BuyingItem buyingItem ;
    LoginPage loginPage;


    @BeforeMethod
    public void setUpPage() throws InterruptedException {
        HomePage homePage= new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.clickLoginSelection();
        loginPage.enterEMailAddress("Bg2@gmail.com")
                .enterPassword("password")
                .clickLoginButton();
        homePage.ClickShopByCategoryLink();
        homePage.ClickComponentsLink();
        buyingItem = new BuyingItem(driver);

    }

    @Description("Checkout Scenario ")
    @Test
    public void addToCartScenario () throws InterruptedException {
        buyingItem.clickListViewButton().clickAddToCartButton();
        buyingItem.clickClosePopupButton();
        buyingItem.clickSvgIcon();
        buyingItem.clickSidebarMenuCheckoutButton();
                buyingItem.clickAgreeCheckoutBox().clickCheckoutButton();
    }
}
