package com.reminder.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainScreenTests extends com.remindly.tests.TestBase {

    @Test
    public void launchAppTest() {
        Assert.assertTrue(app.getMainScreen().isMainScreenMessagePresent());
    }
}
