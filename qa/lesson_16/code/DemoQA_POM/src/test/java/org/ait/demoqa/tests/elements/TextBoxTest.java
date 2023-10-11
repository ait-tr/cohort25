package org.ait.demoqa.tests.elements;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.elements.TextBoxPage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox().hideIframes();
    }

    @Test
    public void keyBoardEventTest() {
        new TextBoxPage(driver).keyBoardEvent("Simensdamm 20")
                .assertCopyPastText("Simensdamm 20");
    }
}
