package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ActionBot.*;

public class CheckoutPage {

    private WebDriver driver ;
    public CheckoutPage(WebDriver driver ) {this.driver=driver;}

    public By checkoutButton = By.id("button-save");
    public By agreeCheckoutBox = By.cssSelector("label[for='input-agree']");
    public By guestCheckoutRadioButton = By.xpath("//label[@for='input-account-guest']");

    //Personal Data
    public By firstNameField = By.id("input-payment-firstname");
    public By lasttNameField = By.id("input-payment-lastname");
    public By emailField = By.id("input-payment-email");
    public By telephoneField = By.id("input-payment-telephone");

    //Billing adress
    public By companyField = By.id("input-payment-company");
    public By address1Field = By.id("input-payment-address-1");
    public By address2Field = By.id("input-payment-address-2");
    public By cityField = By.id("input-payment-city");
    public By postcodeField = By.id("input-payment-postcode");
    public By countryDropdown = By.id("input-payment-country");
    public By regionDropdown = By.xpath("//select[@id='input-payment-zone' and @name='zone_id' and contains(@class, 'custom-select')]");

    //Buttons
    public CheckoutPage clickCheckoutButton () {
        click (driver , checkoutButton);
        return this;
    }
    public CheckoutPage clickAgreeCheckoutBox () {
        click (driver , agreeCheckoutBox);
        return this;
    }
    public CheckoutPage clickGuestCheckoutRadioButton () {
        click (driver , guestCheckoutRadioButton);
        return this;
    }

    //Personal Data
    public CheckoutPage enterFirstName(String firstName){
        type(driver , firstNameField , firstName);
        return this;
    }
    public CheckoutPage enterlasstName(String lastName){
        type(driver , lasttNameField , lastName);
        return this;
    }
    public CheckoutPage enterEmail (String email){
        type(driver , emailField , email);
        return this;
    }
    public CheckoutPage enterTelephone (String telephone){
        type(driver , telephoneField , telephone);
        return this;
    }

    //Billing Address
    public CheckoutPage enterCompany(String company){
        type(driver , companyField , company);
        return this;
    }
    public CheckoutPage enterAddress1(String address1){
        type(driver , address1Field , address1);
        return this;
    }
    public CheckoutPage enterAddress2(String address2){
        type(driver , address2Field , address2);
        return this;
    }
    public CheckoutPage enterCity(String city){
        type(driver , cityField , city);
        return this;
    }
    public CheckoutPage enterPostcode(String postalCode){
        type(driver , postcodeField , postalCode);
        return this;
    }

    public CheckoutPage selectCountryByName(String countryName) {
        selectByVisibleText(driver ,countryDropdown , countryName );
        return this;
    }
    public CheckoutPage selectCountryByIndex(int index) {
        selectByIndex(driver ,countryDropdown , index );
        return this;
    }
    public CheckoutPage selectRegionByName(String regionName) {
        selectByVisibleText(driver ,regionDropdown , regionName );
        return this;
    }
    public CheckoutPage selectRegionByIndex(int index) {
        selectByIndex(driver ,regionDropdown , index );
        return this;
    }
}

