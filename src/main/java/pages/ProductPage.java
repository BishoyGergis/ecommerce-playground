package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utils.ActionBot.click;


public class ProductPage {
    private WebDriver driver ;
    public ProductPage(WebDriver driver ) {this.driver=driver;}

    public By listViewButton = By.id("list-view");
    public By addToCartButton = By.className("cart-36");
    public By cartItemCounter = By.cssSelector("span.badge.badge-pill.badge-info.cart-item-total");
    public By closePopupButton = By.cssSelector(".close");
    public By svgIcon = By.cssSelector("a.cart.text-reset.text-decoration-none.no-title");
    public By sidebarMenuCheckoutButton = By.cssSelector("a.btn.btn-secondary.btn-lg.btn-block[role='button']");

    public ProductPage clickListViewButton () {
        click (driver , listViewButton);
        return this;
    }
    public ProductPage clickAddToCartButton () {

        click (driver , addToCartButton);
        return this;
    }
    public String getCartItemCounter (){
        return driver.findElement(cartItemCounter).getText();
    }
    public ProductPage clickClosePopupButton () {
        click (driver , closePopupButton);
        return this;
    }
    public ProductPage clickSvgIcon () {
        click (driver , svgIcon);
        return this;
    }
    public ProductPage clickSidebarMenuCheckoutButton () {
        click (driver , sidebarMenuCheckoutButton);
        return this;
    }


}

