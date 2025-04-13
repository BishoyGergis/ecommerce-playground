package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static utils.ActionBot.click;


public class HomePage {

    private WebDriver driver ;
    public HomePage (WebDriver driver ) {this.driver=driver;}

    public By megaMenuLink = By.xpath("//a[contains(@class, 'dropdown-toggle') and .//span[normalize-space(text())='Mega Menu']]");
    public By appleLink  = By.cssSelector("a.nav-link.icon-left.text.active[title='Apple']");
    public By registerLink = By.xpath("//a[@class='icon-left both dropdown-item']//span[normalize-space(text())='Register']");
    public By myAccountLink = By.xpath("//a[@class='icon-left both nav-link dropdown-toggle']//span[normalize-space(text())='My account']");
    public By shopByCategoryLink = By.cssSelector("a.icon-left.both.text-reset");
    public By componentsLink = By.cssSelector("a.icon-left.both.nav-link[href='https://ecommerce-playground.lambdatest.io/index.php?route=product/category&path=25']");







    public HomePage clickAppleSection ()
    {
        new Actions(driver).moveToElement(driver.findElement(megaMenuLink)).perform();
        click (driver , appleLink);
        return this;
    }

    public HomePage ClickComponentsLink ()
    {

        click (driver , componentsLink);
        return this;
    }

    public HomePage ClickShopByCategoryLink ()
    {
        click (driver , shopByCategoryLink);
        return this;
    }

    public HomePage waitShopByCategoryLink (){
        ;
        return this;
    }

    public HomePage clickLoginSelection ()  {
        click(driver , myAccountLink);
        return this;
    }
    public HomePage clickRegisterSelection ()
    {
       new Actions(driver).moveToElement(driver.findElement(myAccountLink)).perform();

        click (driver , registerLink);

        return this;
    }
}
