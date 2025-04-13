package testCases;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.BuyingItem;


public class AddToCartTest extends BaseTest {
    BuyingItem buyingItem ;

    @BeforeMethod
    public void setUpPage()  {
        HomePage homePage= new HomePage(driver);
        homePage.ClickShopByCategoryLink().ClickComponentsLink();

         buyingItem = new BuyingItem(driver);
    }

    @Description("Add to Cart Scenario")
    //@Test
    public void addToCartScenario () throws InterruptedException {
        buyingItem.clickListViewButton().clickAddToCartButton().clickAddToCartButton();
        System.out.println("Cart Item Count should be 0 : " + buyingItem.getCartItemCounter());
        Thread.sleep(2000);
        //waitForLoading( driver , buyingItem.cartItemCounter);
        System.out.println("Cart Item Count should be  : " + buyingItem.getCartItemCounter());


    }

}
