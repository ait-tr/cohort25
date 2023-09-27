package org.ait.demoqa.pages.bookStore;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement user;

    public ProfilePage verifyUserName(String userName) {

        Assert.assertTrue(shouldHaveText(user, userName, 10));
        return this;
    }

    @FindBy(id = "deleate-record-undefined")
    List<WebElement> bookListTrash;

    @FindBy(id = "closeSmallModal-ok")
    WebElement okButton;

    public ProfilePage deleteBook() {
        bookListTrash.get(0).click();
        click(okButton);
        pause(500);
        driver.switchTo().alert().accept();
        return this;
    }
}
