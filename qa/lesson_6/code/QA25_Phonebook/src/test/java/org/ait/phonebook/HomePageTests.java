package org.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest() {
        //System.out.println("Home Component is " + isHomeComponentPresent());
        //System.out.println("Home Component is " + isElementPresent(By.xpath("//h1[contains(.,'Home Component')]")));

        Assert.assertTrue(isHomeComponentPresent());
    }
}
