package org.ait.demoqa.tests.alertsFrameWindows;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.alertsFrameWindows.FramePage;
import org.ait.demoqa.pages.alertsFrameWindows.NestedFramesPage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsFramesWindows();
    }

    @Test
    public void iframesTest() {
        new SidePanel(driver).selectFrame();
        new FramePage(driver).returnListOfFrames().switchToIframeByIndex(2);
    }

    @Test
    public void switchToIframeByIDTest() {
        new SidePanel(driver).selectFrame();
        new FramePage(driver).switchToIframeByID();
    }

    @Test
    public void handleNestedIframeTest() {
        new SidePanel(driver).selectNestedFrames();
        new NestedFramesPage(driver).handleNestedIframes();
    }
}
