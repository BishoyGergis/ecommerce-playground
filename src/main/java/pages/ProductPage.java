package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static utils.ActionBot.*;


public class ProductPage {
    private WebDriver driver ;
    public ProductPage(WebDriver driver ) {this.driver=driver;}

    public By listViewButton = By.id("list-view");

    public By cartItemCounter = By.cssSelector("span.badge.badge-pill.badge-info.cart-item-total");
    public By closePopupButton = By.cssSelector(".close");
    public By inStockFilterCheckbox = By.xpath("//label[@for='mz-fss-0--1' and @class='custom-control-label']");
    public By outStockFilterCheckbox = By.xpath("//label[@for='mz-fss-0-5' and @class='custom-control-label']");
    public By cartIcon = By.cssSelector("a.cart.text-reset.text-decoration-none.no-title");
    public By sidebarMenuEditCartButton  = By.cssSelector("a.btn.btn-primary.btn-lg.btn-block");
    public By sidebarMenuCheckoutButton = By.cssSelector("a.btn.btn-secondary.btn-lg.btn-block[role='button']");
    public By productContainer = By.cssSelector(".product-thumb");
    public By productName = By.cssSelector("h4.title a");
    public By productPrice = By.cssSelector(".price .price-new");
    public By productaddToCartButto = By.cssSelector("button.btn-cart");

    public ProductPage clickListViewButton () {
        click (driver , listViewButton);
        return this;
    }
    public ProductPage clickInStockFilterCheckbox ()  {
        click (driver , inStockFilterCheckbox);


        return this;
    }
    public ProductPage clickOutStockFilterCheckbox () {
        click (driver , outStockFilterCheckbox);
        return this;
    }
    public String getCartItemCounter (){
        return driver.findElement(cartItemCounter).getText();
    }
    public ProductPage clickClosePopupButton () {
        click (driver , closePopupButton);
        return this;
    }
    public ProductPage clickCartIcon() {
        click (driver , cartIcon);
        return this;
    }
    public ProductPage clickSidebarMenuEditCartButton () {
        click (driver , sidebarMenuEditCartButton);
        return this;
    }
    public ProductPage clickSidebarMenuCheckoutButton () {
        click (driver , sidebarMenuCheckoutButton);
        return this;
    }


    public List<WebElement> getAllProductContainers() {
        return getListOfElements(driver,productContainer);
    }
    public String getProductNameByIndex (int productIndex) {
        WebElement product = getAllProductContainers().get(productIndex);
        return getText(driver ,product, productName);
    }
    public String getProductPriceByIndex (int productIndex) {
        WebElement product = getAllProductContainers().get(productIndex);
        return getText(driver ,product, productPrice);
    }
    public ProductPage clickProductByIndex (int productIndex) {
        WebElement product = getAllProductContainers().get(productIndex);
        click(driver,product,productaddToCartButto);
        return this ;
    }


}

