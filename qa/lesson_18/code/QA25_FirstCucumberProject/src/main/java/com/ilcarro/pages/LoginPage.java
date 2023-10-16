package com.ilcarro.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    public LoginPage enterData(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        return this;
    }

    @FindBy(css = "[type='submit']")
    WebElement yallaButton;

    public LoginPage clickOnYallaButton() {
        click(yallaButton);
        return this;
    }

    @FindBy(xpath = "//h2[.='Logged in success']")
    WebElement successLogin;

    public LoginPage isLoginMessageDisplayed() {
        //  pause(1000);
        assert isElementDisplayed(successLogin);
        return this;
    }

    public LoginPage enterWrongData(DataTable dataTable) {
        List<Map<String,String>> table = dataTable.asMaps();

        String email = table.get(0).get("email");
        String password = table.get(0).get("password");
        enterData(email,password);
        return this;
    }

    @FindBy(xpath = "//h2[.='\"Login or Password incorrect\"']")
    WebElement error;

    public LoginPage getError() {
        assert isElementDisplayed(error);
        return this;
    }
}
