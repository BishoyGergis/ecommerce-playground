package testCases;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    LoginPage loginPage;

    @BeforeMethod
    public void setUpPage() {
        loginPage = new LoginPage(driver);
    }

    @Description("Enter Valid Mail & Password")
    @Test
    public void SuccessfuLogin () {
        loginPage.enterEMailAddress("beshoy3.bg@gmail.com")
                .enterPassword("Password")
                .clickLoginButton();
    }
}
