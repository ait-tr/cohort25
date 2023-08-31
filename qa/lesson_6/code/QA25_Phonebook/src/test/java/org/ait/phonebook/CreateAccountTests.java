package org.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        if(!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        //click on Login link - a:nth-child(4) - css
        clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        fillLoginRegistrationForm("leno@gmail.com", "Bernd1234$");
        //click on Registration button - //button[text()='Registration'] - xpath
        clickOnRegistrationButton();
        //assert alert is appeared
        Assert.assertTrue(isAlertPresent());
    }
}
