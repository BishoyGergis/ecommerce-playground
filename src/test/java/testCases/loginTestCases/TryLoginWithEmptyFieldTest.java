package testCases.loginTestCases;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TryLoginWithEmptyFieldTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUpPage()  {
        HomePage homePage= new HomePage(driver);
        homePage.clickLoginSelection();
        loginPage = new LoginPage(driver);
    }

    @Description("Try to login with Email adress and passwords fields are empty")
    @Test
    public void SuccessfuLogin () {
        loginPage.clickLoginButton();

        //Assert.assertEquals("Warning: No match for E-Mail Address and/or Password",loginPage.getLoginWarningMessage());
        //Assert.assertEquals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.",loginPage.getLoginAttemptWarningMessage());
        Assert.assertTrue(loginPage.getLoginAttemptWarningMessage()
                .contains("Your account has exceeded allowed number of login attempts")
                ||loginPage.getLoginAttemptWarningMessage()
                .contains("No match for E-Mail Address and/or Password" ));

    }
}
