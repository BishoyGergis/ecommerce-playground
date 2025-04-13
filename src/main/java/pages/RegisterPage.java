package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ActionBot.*;
import static utils.ActionBot.getAttributeValue;

public class RegisterPage {

    private WebDriver driver ;
    public RegisterPage (WebDriver driver ) {this.driver=driver;}

    public By firstNameField = By.id("input-firstname");
    public By lasttNameField = By.id("input-lastname");
    public By emailField = By.id("input-email");
    public By telephoneField = By.id("input-telephone");
    public By passwordField = By.id("input-password");
    public By confirmPasswordField = By.id("input-confirm");
    public By subscribeYesRadioButton = By.cssSelector("label[for='input-newsletter-yes']");
    public By subscribeNoRadioButton = By.cssSelector("label[for='input-newsletter-no']");
    public By privacyPolicyCheckbox = By.cssSelector("label[for='input-agree']");
    public By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
    public By accountCreatedMessage = By.xpath("//h1[contains(text(), 'Your Account Has Been Created!')]");


    public RegisterPage enterFirstName(String firstName){
        type(driver , firstNameField , firstName);
        return this;
    }
    public RegisterPage enterlasstName(String lastName){
        type(driver , lasttNameField , lastName);
        return this;
    }
    public RegisterPage enterEmail (String email){
        type(driver , emailField , email);
        return this;
    }
    public RegisterPage enterTelephone (String telephone){
        type(driver , telephoneField , telephone);
        return this;
    }
    public RegisterPage enterPassword(String password){
        type(driver , passwordField , password);
        return this;
    }
    public RegisterPage enterConfirmPassword(String ConfrimPassword){
        type(driver , confirmPasswordField , ConfrimPassword);
        return this;
    }
    public RegisterPage clickSubscribeYesRadioButton () {
        click (driver , subscribeYesRadioButton);
        return this;
    }
    public RegisterPage clickSubscribeNoRadioButton () {
        click (driver , subscribeNoRadioButton);
        return this;
    }
    public RegisterPage clickPrivacyPolicyCheckbox () {
        click (driver , privacyPolicyCheckbox);
        return this;
    }
    public void clickcontinueButton () {
        click (driver , continueButton);
    }

    public String getAccountCreatedMessage (){
        return driver.findElement(accountCreatedMessage).getText();
    }



}
