package testCases.searchTestCases;

import baseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class searchTest extends BaseTest {
    HomePage homePage;
    @BeforeMethod
    public void setUpPage()  {
         homePage= new HomePage(driver);
    }

    @Test
    public void SeachTest() throws InterruptedException {
        homePage.enterSearchText("phone");
        List<WebElement> products = homePage.getProductList();

        for (WebElement product : products) {
            Thread.sleep(200);
            System.out.println(product.getText());
            Assert.assertTrue((product.getText().contains("Phone")));
        }

    }

}
