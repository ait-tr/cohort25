package org.ait.demoqa.tests;

import org.ait.demoqa.pages.BookStorePage;
import org.ait.demoqa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStore();
    }

    @Test
    public void searchBookTest() {
        new BookStorePage(driver).enterBookName("Git")
                .verifyBookName("Git");
    }
}
