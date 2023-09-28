package org.ait.demoqa.pages.widgets;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Main Item 2']")
    WebElement mainItem2;

    @FindBy(xpath = "//a[.='SUB SUB LIST »']")
    WebElement subSubList;

    public MenuPage selectSubMenu() {
        pause(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();
        pause(500);
        actions.moveToElement(subSubList).perform();

        return this;
    }

    public MenuPage assertSubMenu() {
        Assert.assertTrue(subSubList.isDisplayed());
        return this;
    }
}
