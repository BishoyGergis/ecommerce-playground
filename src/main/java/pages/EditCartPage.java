package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.ActionBot.click;
import static utils.ActionBot.getListOfElements;

public class EditCartPage {

    private WebDriver driver ;
    public EditCartPage(WebDriver driver ) {this.driver=driver;}

    public By checkoutButton = By.linkText("Checkout");
    public By stockAlertMsg = By.cssSelector("div.alert.alert-danger.alert-dismissible");
    public By cartItems = By.cssSelector("div.table-responsive > table.table-bordered > tbody > tr");
    public By outOfStockMarkers =By.cssSelector("span.text-danger");
    public By removeButton  =By.cssSelector("button.btn-danger[onclick^='cart.remove']");

    public EditCartPage clickCheckoutButton () {
        click (driver , checkoutButton);
        return this;
    }

    public List<WebElement> getCartItems () {
        return getListOfElements(driver,cartItems);
    }

    public String getStockAlertMsg (){
        return driver.findElement(stockAlertMsg).getText();
    }

    public EditCartPage removeOutOfStockItems ( ) {
        List <WebElement> allItems= getListOfElements(driver ,cartItems );
        for (WebElement item : allItems)
        {
            // Check if the row contains the '***' span
            List <WebElement> outOfStockItem = item.findElements(outOfStockMarkers);
            if (outOfStockItem.isEmpty())
            {continue;}
            else
            {
                // It's an out-of-stock item → find the remove button and click it
                item.findElement(removeButton).click();
            }
        }
        return this;
    }

}


