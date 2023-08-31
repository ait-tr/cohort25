package org.ait.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {

        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        fillLoginRegistrationForm("leno@gmail.com", "Bernd1234$");
        click(By.xpath("//button[.='Login']"));
        //click on ADD link - [href='/add'] - css
        click(By.cssSelector("[href='/add']"));
    }

    @Test
    public void addContactPositiveTest() {
        //enter all input fields in contact form - input:nth-child(1) - css
        type(By.cssSelector("input:nth-child(1)"),"Karl");
        type(By.cssSelector("input:nth-child(2)"),"Adam");
        type(By.cssSelector("input:nth-child(3)"),"1234567890");
        type(By.cssSelector("input:nth-child(4)"),"adam@gm.com");
        type(By.cssSelector("input:nth-child(5)"),"Koblenz");
        type(By.cssSelector("input:nth-child(6)"),"goalkeeper");
        //click on Save button - .add_form__2rsm2 button - css
        click(By.cssSelector(".add_form__2rsm2 button"));
        //assert by text contact is added
        Assert.assertTrue(isContactAdded("Karl"));
    }

    @AfterMethod
    public void postCondition(){
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el: contacts) {
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }
}
