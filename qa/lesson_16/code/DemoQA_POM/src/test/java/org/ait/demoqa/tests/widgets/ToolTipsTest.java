package org.ait.demoqa.tests.widgets;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.widgets.ToolTipsPage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectToolTips().hideIframes();
    }

    @Test
    public void toolTipsTest() {
        new ToolTipsPage(driver).hoverToolTips()
                .assertToolTips("textFieldToolTip");
    }
}
