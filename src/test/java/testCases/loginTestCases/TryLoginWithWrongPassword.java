package testCases.loginTestCases;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TryLoginWithWrongPassword extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUpPage()  {
        HomePage homePage= new HomePage(driver);
        homePage.clickLoginSelection();
        loginPage = new LoginPage(driver);
    }

    @Description("Try to login with valid Email  and wrong passwords ")
    @Test
    public void SuccessfuLogin () {
        loginPage.enterEMailAddress("Bg2@gmail.com")
                .enterPassword("wrongPassword")
                .clickLoginButton();

        Assert.assertTrue(loginPage.getLoginAttemptWarningMessage()
                .contains("Your account has exceeded allowed number of login attempts")
                ||loginPage.getLoginAttemptWarningMessage()
                .contains("No match for E-Mail Address and/or Password" ));

    }
}
