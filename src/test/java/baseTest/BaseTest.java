package baseTest;

import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import pages.HomePage;


import java.io.IOException;


public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeClass
    public void setUpAndOpenBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io");
    }

    @AfterClass
    public void tearDownBrowser() throws IOException {
        // Quit the driver
        if (driver != null) {
            driver.quit();
        }
    }
}
