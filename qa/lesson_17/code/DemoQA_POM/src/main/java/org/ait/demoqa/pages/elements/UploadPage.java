package org.ait.demoqa.pages.elements;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UploadPage extends BasePage {
    public UploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public UploadPage performKeyEventWithRobot() {
        pause(1000);
        clickWithRectangle(uploadFile,2,4);
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //press SHIFT key
        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(1000);
        //press d(upper case as SHIFT key is pressed)
        robot.keyPress(KeyEvent.VK_D);
        //release SHIFT key
        robot.keyRelease(KeyEvent.VK_SHIFT);
        //press 1, ., t,x,t
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        //press ENTER key
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public UploadPage assertPath(String path) {
        Assert.assertTrue(isTextPresent(uploadedFilePath,path));
        return this;
    }

    public UploadPage performMouseEvent() {
        pause(1000);
        clickWithRectangle(uploadFile,2,4);
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        //find x and y coordinates to pass to mouseMove method
        //get window size
        Dimension dimension = driver.manage().window().getSize();
        System.out.println("Dimension x and y: " + dimension.getWidth() + " " + dimension.getHeight());
        //get point of file location
        int x = dimension.getWidth()/4 + 500;
        int y = dimension.getHeight()/2;
        //move mouse point with coordinates
        robot.mouseMove(x,y);
        pause(1000);
        //click left mouse button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //release left mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(1000);
        //press ENTER key
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }
}
