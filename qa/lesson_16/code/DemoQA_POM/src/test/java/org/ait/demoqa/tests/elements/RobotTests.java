package org.ait.demoqa.tests.elements;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.elements.UploadPage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RobotTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectUpload().hideIframes();
    }

    @Test
    public void performKeyEventWithRobotTest() {
        new UploadPage(driver).performKeyEventWithRobot()
                .assertPath("C:\\fakepath\\D1.txt");
    }

    @Test
    public void performMouseEventTests() {
        new UploadPage(driver).performMouseEvent()
                .assertPath("C:\\fakepath\\D1.txt");
    }
}
