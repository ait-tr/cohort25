package org.ait.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TableTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void tableByCssTest() {
        //numbers of rows
        List<WebElement> tr = driver.findElements(By.cssSelector("tr"));
        System.out.println("Rows in table --> " + tr.size());
        System.out.println("====================================");
        for (int i = 0; i < tr.size(); i++) {
            System.out.println(tr.get(i).getText());
            System.out.println("================================");
        }

        //numbers of columns
        List<WebElement> columns = driver.findElements(By.cssSelector("tr th"));
        System.out.println("Columns in tables --> " + columns.size());
        System.out.println("========================================");

        //print row 3
        List<WebElement> row3 = driver.findElements(By.cssSelector("tr:nth-child(3) td"));

        for (WebElement el:row3) {
            System.out.println(el.getText());
            System.out.println("===========================================");
        }

        //print last columns
        List<WebElement> lastColumn = driver.findElements(By.cssSelector("tr td:last-child"));

        for (WebElement el1:lastColumn) {
            System.out.println(el1.getText());
            System.out.println("=====================================================");
        }

        //print column2 row2
        System.out.println(driver.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(2)")).getText());
    }

    @Test
    public void tableXpathTest() {
        //numbers of rows
        List<WebElement> tr = driver.findElements(By.xpath("//tr"));
        System.out.println("Rows in table --> " + tr.size());
        System.out.println("====================================");
        for (int i = 0; i < tr.size(); i++) {
            System.out.println(tr.get(i).getText());
            System.out.println("================================");
        }

        //numbers of columns
        List<WebElement> columns = driver.findElements(By.xpath("//tr/th"));
        System.out.println("Columns in tables --> " + columns.size());
        System.out.println("========================================");

        //print row 3
        List<WebElement> row3 = driver.findElements(By.xpath("//tr[3]//td"));

        for (WebElement el:row3) {
            System.out.println(el.getText());
            System.out.println("===========================================");
        }

        //print last columns
        List<WebElement> lastColumn = driver.findElements(By.xpath("//tr/td[last()]"));

        for (WebElement el1:lastColumn) {
            System.out.println(el1.getText());
            System.out.println("=====================================================");
        }
        System.out.println(driver.findElement(By.xpath("//td[text()='Maria Anders']")).getText());
        System.out.println(driver.findElement(By.xpath("//td[contains(.,'Maria')]")).getText());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

 /*xpath - //beginning el/relationship::tagName
    sibling - preceding-sibling
            following-sibling
            //td[text()='Sweden']/preceding-sibling::td[1]
            //td[text()='Ernst Handel']/following-sibling::td[1]

    parent & child
        //td[text()='Sweden']/parent::tr

   descendant
    //table[@id='customers']/descendant::td[1]

    ancestor
    //td[text()='Sweden']/ancestor::table
*/
