package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ActionBot {

    // Typing in text box
    public static void type(WebDriver driver, By locator, String text) {
       // Waits.getFluentWait(driver).until(f -> {
            System.out.println("Typing " + text);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
           // return true;
       // });
    }

    public static void click ( WebDriver driver , By locator)
    {
        System.out.println("Clicking on " + driver.findElement(locator).getText());
        driver.findElement(locator).click();
    }
}
