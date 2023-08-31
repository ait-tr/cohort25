package org.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
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
    public void loginPositiveTest() {
        //enter email - [placeholder='Email'] - css
        fillLoginRegistrationForm("leno@gmail.com", "Bernd1234$");
        //click on Login button
        click(By.xpath("//button[.='Login']"));
        //assert Sign Out button present
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));
    }
}
