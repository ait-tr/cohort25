package org.ait.demoqa.tests.widgets;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.widgets.AutoCompletePage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectAutoComplete();
    }

    @Test
    public void autoCompleteTest() {
        new AutoCompletePage(driver).autoComplete()
                .assertAutoComplete("Magenta");
    }
}
