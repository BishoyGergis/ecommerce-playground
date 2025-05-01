package testCases.loginTestCases;

import baseTest.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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

    @Feature("Authentication")
    @Story("Successful login with valid credentials")
    @Description("Successfully login using a valid email and password and verify redirection to the My Account page")
    @Test
    public void successfuLogin () {
        Allure.step("Log in using valid email and password credentials");
        loginPage.enterEMailAddress("Bg7@gmail.com")
                .enterPassword("password1")
                .clickLoginButton();

        Allure.step("Verify that the user is successfully redirected to the 'My Account' page");
        Assert.assertEquals("My Account",loginPage.getMyAccountHeader());
    }

}
