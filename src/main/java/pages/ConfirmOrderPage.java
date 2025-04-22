package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ActionBot.*;

public class ConfirmOrderPage {

    private WebDriver driver ;
    public ConfirmOrderPage(WebDriver driver ) {this.driver=driver;}

    public By confirmOrderPageTitle = By.cssSelector("h1.page-title.mb-3");
    public By confirmOrderButton = By.id("button-confirm");
    public By orderPlacedTitle = By.cssSelector(".page-title.my-3");


    public ConfirmOrderPage clickConfirmOrderButton () {
        click (driver , confirmOrderButton);
        return this;
    }

    public String getOrderPlacedTitle (){
        return getText(driver , orderPlacedTitle);
    }



}
