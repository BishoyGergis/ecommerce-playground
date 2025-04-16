package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ActionBot.click;

public class EditCartPage {

    private WebDriver driver ;
    public EditCartPage(WebDriver driver ) {this.driver=driver;}

    public By checkoutButton = By.linkText("Checkout");
    public By stockAlertMsg = By.cssSelector("div.alert.alert-danger.alert-dismissible");

    public EditCartPage clickCheckoutButton () {
        click (driver , checkoutButton);
        return this;
    }

    public String getStockAlertMsg (){
        return driver.findElement(stockAlertMsg).getText();
    }

}
