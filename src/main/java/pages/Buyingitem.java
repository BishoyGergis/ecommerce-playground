package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ActionBot.click;

public class Buyingitem {

    private WebDriver driver ;
    public Buyingitem (WebDriver driver ) {this.driver=driver;}


    public By megaMenuLink = By.xpath("//a[contains(@class, 'dropdown-toggle') and .//span[text()=' Mega Menu ']]");
    public By appleLink = By.xpath("//a[text()='Apple']");
    public By listView = By.id("list-view");
    public By addToCartBtn32 = By.xpath("//button[@onclick=\"cart.add('32');\"]");
    public By addToCartBtn34 = By.xpath("//button[@onclick=\"cart.add('34');\"]");
    public By cartDrawerButton = By.cssSelector("a[href='#cart-total-drawer']");
    public By cartText = By.cssSelector(".cart-items");
    public By checkoutButton = By.cssSelector("a.btn.btn-secondary.btn-lg.btn-block");



    public Buyingitem clickMegaMenu ()
    {
        click (driver , megaMenuLink);
        return this;
    }

    public Buyingitem clickAppleSection ()
    {
        click (driver , appleLink);
        return this;
    }
    public Buyingitem clickListView ()
    {
        click (driver , listView);
        return this;
    }
    public Buyingitem clickiPodTouch ()
    {
        click (driver , addToCartBtn32);
        return this;
    }
    public Buyingitem clickiPodShuffle ()
    {
        click (driver , addToCartBtn34);
        return this;
    }
}
