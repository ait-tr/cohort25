package org.ait.demoqa.tests.interactions;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.interactions.DroppablePage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDragTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectDroppable().hideIframes();
    }

    @Test
    public void dragMeTest() {
        new DroppablePage(driver).actionDragMe()
                .assertDropped("Dropped!");
    }

    @Test
    public void dragMeByTest() {
        new DroppablePage(driver).actionDragMeBy(20,50)
                .assertDropped("Dropped!");
    }
}
