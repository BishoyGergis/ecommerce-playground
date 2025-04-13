package testCases;

import baseTest.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BuyingItem;

public class BuyingItemTest extends BaseTest {


    BuyingItem buyingitem;

   // @BeforeMethod
    public void setUpPage() {
        buyingitem = new BuyingItem(driver);
        //HomePage = new LoginPage(driver);
    }

    //@Test
    public void AddToCart () {

    }


}
