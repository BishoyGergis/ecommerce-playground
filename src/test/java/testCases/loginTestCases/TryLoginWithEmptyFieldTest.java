package testCases.loginTestCases;

import baseTest.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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

    @Feature("Authentication")
    @Story("Login failure when credentials are missing")
    @Description("Verify that attempting to log in without entering email and password results in an appropriate warning message")
    @Test
    public void loginWithEmptyFields () {
        Allure.step("Try to log in without entering email and password");
        loginPage.clickLoginButton();

        Allure.step("Ensure login fails and the appropriate warning message is shown");
        Assert.assertTrue(loginPage.getLoginWarningMessage()
                .contains("Your account has exceeded allowed number of login attempts")
                ||loginPage.getLoginWarningMessage()
                .contains("No match for E-Mail Address and/or Password" ));

    }
}
