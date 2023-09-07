package org.ait.phonebook;

import org.ait.phonebook.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    // @BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();
    }

    //  @AfterMethod(enabled = true)
    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void startTest() {
        logger.info("Start test");
    }

    @AfterMethod
    public void stopTest() {
        logger.info("Stop test");
    }

}

/*@BeforeTest
    @BeforeMethod
        @BeforeClass
            @BeforeSuite
                @BeforeGroups
                @AfterGroups
            @AfterSuite
        @AfterClass
    @AfterMethod
@AfterTest*/
