package org.ait.demoqa.tests.widgets;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.widgets.MenuPage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectMenu();
    }

    @Test
    public void selectMenuTest() {
        new MenuPage(driver).selectSubMenu()
                .assertSubMenu();
    }
}
