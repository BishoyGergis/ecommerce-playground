package testCases.registerTestCases;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage;

    @BeforeMethod
    public void setUpPage()  {
        HomePage homePage= new HomePage(driver);
        homePage.clickRegisterSelection();
        registerPage= new RegisterPage(driver);
    }

    @Description("Enter Valid Mail & Password")
    @Test
    public void SuccessfulRegister () {
        registerPage.enterFirstName("Bishoy")
                .enterlasstName("Gergis")
                .enterEmail("Bg7@gmail.com")
                .enterTelephone("12345")
                .enterPassword("password1")
                .enterConfirmPassword("password1")
                .clickSubscribeYesRadioButton()
                .clickPrivacyPolicyCheckbox().clickcontinueButton();
        Assert.assertEquals("Your Account Has Been Created!",registerPage.getAccountCreatedMessage());


    }



}
