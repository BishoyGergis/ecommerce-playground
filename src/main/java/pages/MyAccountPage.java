package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;

import utils.ActionBot;
import static utils.ActionBot.*;

public class MyAccountPage {
    private WebDriver driver ;
    public MyAccountPage (WebDriver driver ) {this.driver=driver;}

    public By editYourAccountinfolink=By.linkText("Edit your account information");
    public By changePasswordLink = By.linkText("Change your password");
    public By modifyAddressBookLink = By.linkText("Modify your address book entries");
    public By modifyWishListLink = By.linkText("Modify your wish list");
    public By newsletterSubscriptionLink = By.linkText("Subscribe / unsubscribe to newsletter");



}
