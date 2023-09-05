package org.ait.phonebook;

import org.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

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
    public void existedUserRegistrationNegativeTest() {
        //  int i = (int) (System.currentTimeMillis()/1000%3600);

        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("leno@gmail.com")
                .setPassword("Bernd1234$"));
        //click on Registration button - //button[text()='Registration'] - xpath
        app.getUser().clickOnRegistrationButton();
        //assert alert is appeared
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
