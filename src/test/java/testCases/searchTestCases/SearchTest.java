package testCases.searchTestCases;

import baseTest.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.List;

public class SearchTest extends BaseTest {
    HomePage homePage;
    @BeforeMethod
    public void setUpPage()  {
         homePage= new HomePage(driver);
    }

    @Feature("Product Search")
    @Story("Search for items using the search bar")
    @Description("Verify that relevant products are displayed when a valid search keyword is entered")
    @Test
    public void SeachByName() throws InterruptedException {
        Allure.step("Input the desired search string in the search field");
        homePage.enterSearchText("phone");
        List<WebElement> products = homePage.getProductList();

        Allure.step("Verify that the search results contain the expected item");
        for (WebElement product : products) {
            Thread.sleep(200);
            System.out.println(product.getText());
            Assert.assertTrue((product.getText().contains("Phone")));
        }
    }
}
