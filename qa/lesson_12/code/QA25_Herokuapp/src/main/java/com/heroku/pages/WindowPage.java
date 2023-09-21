package com.heroku.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WindowPage extends BasePage{

    public WindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Click Here']")
    WebElement clickHere;

    public WindowPage switchToNewTab(int index) {
        click(clickHere);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(tagName = "h3")
    WebElement title;

    public WindowPage verifyNewTabTitle(String text) {
        Assert.assertTrue(isTextPresent(title,text));
        return this;
    }
}
