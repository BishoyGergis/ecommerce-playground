package testCases.loginTestCases;

import baseTest.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.*;
import org.junit.Assert;
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

    @Feature("Authentication")
    @Story("Login failure with incorrect password")
    @Description("Verify that login fails and a warning message appears when a valid email is entered with an incorrect password")
    @Test
    public void loginWithWrongPassword () {
        Allure.step("Enter the user's email with an incorrect password");
        loginPage.enterEMailAddress("Bg4@gmail.com")
                .enterPassword("wrongPassword")
                .clickLoginButton();

        Allure.step("Ensure login fails and the appropriate warning message is shown");
        Assert.assertTrue(loginPage.getLoginWarningMessage()
                .contains("Your account has exceeded allowed number of login attempts")
                ||loginPage.getLoginWarningMessage()
                .contains("No match for E-Mail Address and/or Password" ));

    }
}
