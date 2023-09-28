package org.ait.demoqa.tests.elements;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.elements.ButtonsPage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectButtons();
    }

    @Test
    public void doubleClickTest() {
        new ButtonsPage(driver).doubleClick()
                .assertDoubleClick("You have done a double click");
    }

    @Test
    public void rightClickTest() {
        new ButtonsPage(driver).rightClick()
                .assertRightClick("You have done a right click");
    }
}
