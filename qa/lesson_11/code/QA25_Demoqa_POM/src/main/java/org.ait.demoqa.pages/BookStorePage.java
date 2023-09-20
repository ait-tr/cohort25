package org.ait.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookStorePage extends BasePage{

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchBox;


    public BookStorePage enterBookName(String book) {
        type(searchBox,book);
        return this;
    }

    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement bookName;

    public BookStorePage verifyBookName(String book) {
        Assert.assertTrue(bookName.getText().contains(book));
        return this;
    }
}
