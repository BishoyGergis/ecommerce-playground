package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ActionBot.click;

public class BuyingItem {

    private WebDriver driver ;
    public BuyingItem(WebDriver driver ) {this.driver=driver;}


    // Add to Cart
    public By listViewButton = By.id("list-view");
    public By addToCartButton = By.className("cart-36");
    public By cartItemCounter = By.cssSelector("span.badge.badge-pill.badge-info.cart-item-total");

    //Checkout
    public By closePopupButton = By.cssSelector(".close");
    public By svgIcon = By.cssSelector("a.cart.text-reset.text-decoration-none.no-title");
    public By sidebarMenuCheckoutButton = By.cssSelector("a.btn.btn-secondary.btn-lg.btn-block[role='button']");
    public By checkoutButton = By.id("button-save");
    public By agreeCheckoutBox = By.cssSelector("label[for='input-agree']");



    public BuyingItem clickListViewButton ()
    {

        click (driver , listViewButton);
        return this;
    }
    public BuyingItem clickAddToCartButton ()
    {

        click (driver , addToCartButton);
        return this;
    }

    public String getCartItemCounter (){
        return driver.findElement(cartItemCounter).getText();
    }

    public BuyingItem clickClosePopupButton () {



        click (driver , closePopupButton);
        return this;
    }

    public BuyingItem clickSvgIcon () {
        click (driver , svgIcon);
        return this;
    }
    public BuyingItem clickSidebarMenuCheckoutButton () {
        click (driver , sidebarMenuCheckoutButton);
        return this;
    }
    public BuyingItem clickCheckoutButton () {
        click (driver , checkoutButton);
        return this;
    }

    public BuyingItem clickAgreeCheckoutBox () {
        click (driver , agreeCheckoutBox);
        return this;
    }






    /*public By megaMenuLink = By.xpath("//a[contains(@class, 'dropdown-toggle') and .//span[text()=' Mega Menu ']]");
    public By appleLink = By.xpath("//a[text()='Apple']");
    public By listView = By.id("list-view");
    public By addToCartBtn32 = By.xpath("//button[@onclick=\"cart.add('32');\"]");
    public By addToCartBtn34 = By.xpath("//button[@onclick=\"cart.add('34');\"]");
    public By cartDrawerButton = By.cssSelector("a[href='#cart-total-drawer']");
    public By cartText = By.cssSelector(".cart-items");
    public By checkoutButton = By.cssSelector("a.btn.btn-secondary.btn-lg.btn-block");



    public BuyingItem clickMegaMenu ()
    {
        click (driver , megaMenuLink);
        return this;
    }

    public BuyingItem clickAppleSection ()
    {
        click (driver , appleLink);
        return this;
    }
    public BuyingItem clickListView ()
    {
        click (driver , listView);
        return this;
    }
    public BuyingItem clickiPodTouch ()
    {
        click (driver , addToCartBtn32);
        return this;
    }
    public BuyingItem clickiPodShuffle ()
    {
        click (driver , addToCartBtn34);
        return this;
    }*/
}
