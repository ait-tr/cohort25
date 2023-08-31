package org.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {

        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        fillLoginRegistrationForm("leno@gmail.com", "Bernd1234$");
        click(By.xpath("//button[.='Login']"));
        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input:nth-child(1)"),"Karl");
        type(By.cssSelector("input:nth-child(2)"),"Adam");
        type(By.cssSelector("input:nth-child(3)"),"1234567890");
        type(By.cssSelector("input:nth-child(4)"),"adam@gm.com");
        type(By.cssSelector("input:nth-child(5)"),"Koblenz");
        type(By.cssSelector("input:nth-child(6)"),"goalkeeper");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test
    public void removeContactPositiveTest() {
        int sizeBefore = sizeOfContacts();
        //click on contact card - .contact-item_card__2SOIM - css
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //click on Remove button - //button[.='Remove'] - xpath
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        int sizeAfter = sizeOfContacts();
        //assert contact is removed
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return  driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}
