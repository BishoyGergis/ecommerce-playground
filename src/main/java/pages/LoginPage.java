package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;

import utils.ActionBot;
import static utils.ActionBot.*;


public class LoginPage {

    private WebDriver driver ;
    public LoginPage (WebDriver driver ) {this.driver=driver;}

    public By EMailAddressField = By.id("input-email");
    public By passwordField = By.id("input-password");
    public By forgottenPasswordLink = By.linkText("Forgotten Password");
    public By loginButton = By.xpath("//input[@type='submit' and @value='Login']");
    public By continueButton = By.linkText("Continue");

    public LoginPage enterEMailAddress(String emailAdress) {
        type(driver, EMailAddressField , emailAdress);
        return this;
    }

    public LoginPage enterPassword (String password)
    {
        type(driver , passwordField , password);
        return this;
    }

    public void clickLoginButton ()
    {
        click (driver , loginButton);
    }

    public void clickForgotPassword () {
        click(driver , forgottenPasswordLink);
    }

    public void clickContinueinButton ()
    {
        click (driver , continueButton);
    }






}
