package testCases.registerTestCases;

import baseTest.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.*;
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

    @Feature("User Registration")
    @Story("Successful account creation with valid data")
    @Description("Verify that a new user can successfully register with valid information and see a confirmation message")
    @Test
    public void SuccessfulRegister () {
        Allure.step("Enter user details into the registration fields");
        registerPage.enterFirstName("Bishoy")
                .enterlasstName("Gergis")
                .enterEmail("Bg17@gmail.com")
                .enterTelephone("12345")
                .enterPassword("password1")
                .enterConfirmPassword("password1")
                .clickSubscribeYesRadioButton()
                .clickPrivacyPolicyCheckbox().clickcontinueButton();
        Allure.step("Verify that the registration was completed successfully");
        Assert.assertEquals("Your Account Has Been Created!",registerPage.getAccountCreatedMessage());


    }



}
