package org.ait.qa25;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenSiteTest {

    WebDriver driver;

    //before - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();// https://googlechromelabs.github.io/chrome-for-testing/
        // kill process - taskkill /F /IM chromedriver.exe /T
        //  driver.get("https://www.google.com");//without history
        driver.navigate().to("https://www.google.com");// with history
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    //tests
    @Test
    public void openGoogleTest() {
        System.out.println("Site opened!!!");
    }

    //after - tearDown
    @AfterMethod
    public void tearDown() {
        //  driver.quit();//all tabs & browser
        driver.close();//only one tab, if tab only one - close browser
    }
}
