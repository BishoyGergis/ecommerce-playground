package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;


public class ActionBot {

    // Typing in text box
    public static void type(WebDriver driver, By locator, String text) {

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
                    System.out.println("Typing " + text);
                    driver.findElement(locator).clear();
                    driver.findElement(locator).sendKeys(text);

                    return true;
                });
    }
    // clicking on element
    public static void click ( WebDriver driver , By locator) {
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
                    System.out.println("Clicking on " + driver.findElement(locator).getText());
                    driver.findElement(locator).click();

                    return true;
                });
    }
    public static void click(WebDriver driver, WebElement parentElement, By childLocator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NotFoundException.class);

        wait.until(d -> parentElement.findElement(childLocator).isDisplayed());
        wait.until(d -> parentElement.findElement(childLocator).isEnabled());

        WebElement elementToClick = parentElement.findElement(childLocator);

        System.out.println("Clicking on " + elementToClick.getText());
        elementToClick.click();
    }

    // Get Element Text
    public static String getText (WebDriver driver, By locator ) {
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
                    System.out.println("Getting text: " + driver.findElement(locator ).getText());
                    return true;
                });
        return driver.findElement(locator ).getText();

    }
    public static String getText(WebDriver driver, WebElement parentElement, By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NotFoundException.class);

        wait.until(d -> parentElement.findElement(locator).isDisplayed());

        WebElement element = parentElement.findElement(locator);
        System.out.println("Getting text: " + element.getText());
        return element.getText();
    }

    // Get List of WebElements
    public static List<WebElement> getListOfElements (WebDriver driver,By locator)  {
        Wait<WebDriver> wait = new FluentWait<>(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated (locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated (locator));
        return driver.findElements(locator);
    }

    // Select from Dropdown List
    public static void selectByVisibleText(WebDriver driver, By locator, String visibleText) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebElement dropdownElement = driver.findElement(locator);
        Select select = new Select(dropdownElement);

        wait.until(
                d-> {
                    select.selectByVisibleText(visibleText);
                    System.out.println("Selected from dropdown: " + visibleText);
                    return true;
                  });
    }
    public static void selectByIndex(WebDriver driver, By locator, int index) {

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebElement dropdownElement = driver.findElement(locator);
        Select select = new Select(dropdownElement);

        wait.until(
                d-> {
                    select.selectByIndex(index);
                    System.out.println("Selected from dropdown: " + index);
                    return true;
                });



    }

    public static String getAttributeValue (WebDriver driver, By locator, String attributeName) {
        WebElement element = driver.findElement(locator);
        return element.getAttribute(attributeName);
    }

}
