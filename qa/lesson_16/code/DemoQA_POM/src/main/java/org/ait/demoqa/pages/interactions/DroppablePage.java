package org.ait.demoqa.pages.interactions;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DroppablePage extends BasePage {

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DroppablePage actionDragMe() {
        pause(1000);
        new Actions(driver).dragAndDrop(dragMe,dropHere).perform();
        return this;
    }

    public DroppablePage assertDropped(String text) {
        Assert.assertTrue(isTextPresent(dropHere,text));
        return this;
    }

    public DroppablePage actionDragMeBy(int x, int y) {
        pause(1000);
        //get coordinates dragMe(from) and print
        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();
        System.out.println("xOffset1 --> " + xOffset1 + " yOffset1 --> " + yOffset1);
        //get coordinates dropHere(to) and print
        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
        System.out.println("xOffset --> " + xOffset + " yOffset --> " + yOffset);
        //get difference xOffset and yOffset
        xOffset = (xOffset - xOffset1) + x;
        yOffset = (yOffset - yOffset1) + y;

        new Actions(driver).dragAndDropBy(dragMe,xOffset,yOffset).perform();
        return this;
    }
}
