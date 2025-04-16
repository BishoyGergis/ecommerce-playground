package testCases.loginTestCases;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginSuccessfullyTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void setUpPage()  {
        HomePage homePage= new HomePage(driver);
        homePage.clickLoginSelection();
        loginPage = new LoginPage(driver);
    }

    @Description("Successfully login, Enter Valid Mail & Password")
    @Test
    public void SuccessfuLogin () {
        loginPage.enterEMailAddress("Bg2@gmail.com")
                .enterPassword("password")
                .clickLoginButton();
        Assert.assertEquals("My Account",loginPage.getMyAccountHeader());
    }

}
