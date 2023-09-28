package org.ait.demoqa.tests.widgets;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.widgets.SliderPage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectSlider();
    }

    @Test
    public void sliderTest() {
        new SliderPage(driver).moveSliderInHorizontalDirection()
                .assertSliderValue("100");
    }
}
