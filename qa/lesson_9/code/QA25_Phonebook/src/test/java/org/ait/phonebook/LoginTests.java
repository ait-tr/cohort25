package org.ait.phonebook;

import org.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        if(!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        //click on Login link - a:nth-child(4) - css
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest() {
        //enter email - [placeholder='Email'] - css
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("leno@gmail.com")
                .setPassword("Bernd1234$"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert Sign Out button present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        //enter email - [placeholder='Email'] - css
        app.getUser().fillLoginRegistrationForm(new User()
                .setPassword("Bernd1234$"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert Sign Out button present
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test
    public void loginPositiveTestWithScreencast() throws IOException, AWTException {
        app.getUser().deleteScreencast();
        app.getUser().startRecording();

        app.getUser().fillLoginRegistrationFormForScreencast(new User()
                .setEmail("leno@gmail.com")
                .setPassword("Bernd1234$"));
        app.getUser().clickOnLoginButtonForScreencast();
        app.getUser().pause(2000);

        app.getUser().stopRecording();

    }
}
