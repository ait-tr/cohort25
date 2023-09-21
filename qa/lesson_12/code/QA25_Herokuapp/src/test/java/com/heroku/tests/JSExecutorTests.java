package com.heroku.tests;

import com.heroku.data.UserData;
import com.heroku.pages.HomePage;
import com.heroku.pages.JSExecutor;
import org.testng.annotations.Test;

public class JSExecutorTests extends TestBase{

    @Test
    public void jsExecutorTest() {
        new HomePage(driver).getFormAuthentication();
        new JSExecutor(driver)
                .enterDataWithJSE(UserData.USER_NAME,UserData.USER_PASSWORD)
                .clickOnLoginButtonWithJSE()
                .checkURLWithJSE();
    }
}
