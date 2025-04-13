package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


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
        Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(300))
            .ignoring(ElementNotInteractableException.class)
            .ignoring(StaleElementReferenceException.class)
            .ignoring(NotFoundException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated (locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated (locator));

        wait.until(
                d -> {
                    driver.findElement(locator).isEnabled();
                    driver.findElement(locator).click();
                    System.out.println("Clicking on " + driver.findElement(locator).getText());
                    return true;
                });
    }

    public static String getAttributeValue (WebDriver driver, By locator, String attributeName) {
        WebElement element = driver.findElement(locator);
        return element.getAttribute(attributeName);
    }

   /*public static void waitForLoading(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }*/
}
