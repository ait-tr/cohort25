package org.ait.demoqa.tests;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.LoginPage;
import org.ait.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStore();
        new SidePanel(driver).selectLogin();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver)
                .login("neuer","Neuer1234!")
                .verifyUserName("neuer");
    }
}
