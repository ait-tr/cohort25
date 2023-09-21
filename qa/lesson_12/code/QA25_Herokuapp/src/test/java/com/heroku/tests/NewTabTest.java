package com.heroku.tests;

import com.heroku.pages.HomePage;
import com.heroku.pages.WindowPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTabTest extends TestBase {

    //click on Multiple Windows link
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getMultipleWindows();
    }

    @Test
    public void switchToNewTabTest() {
        //click on Click here link and switch to new tab
        //assert New tab
        new WindowPage(driver).switchToNewTab(1)
                .verifyNewTabTitle("New Window");
    }

}
