package org.ait.demoqa.tests;

import org.ait.demoqa.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);
    String browser = System.getProperty("browser", Browser.CHROME.browserName());

    public WebDriver driver;

    @BeforeMethod
    public void startLogger(Method m) {
        logger.info("***************************************");
        logger.info("Start method --> " + m.getName());
    }

    @BeforeMethod
    public void init() {
        System.err.close();
        // driver = new ChromeDriver();
        if (browser.equalsIgnoreCase(Browser.CHROME.browserName())) {
            driver = new ChromeDriver();
            logger.info("All test run in Chrome Browser");
        } else if (browser.equalsIgnoreCase(Browser.FIREFOX.browserName())) {
            driver = new FirefoxDriver();
            logger.info("All tests run in Firefox Browser");
        }

        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator(listener).decorate(driver);

        driver.get("https://demoqa.com");
        logger.info("The link --> " + driver.getCurrentUrl());
        logger.info("*************************************************************");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }
}

/*Maven cmd command
        mvn clean test
        mvn clean test -Dbrowser=firefox
        mvn clean test -Dsurefire.suiteXmlFiles=<path to file>*/
