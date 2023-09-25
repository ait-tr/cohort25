package com.heroku.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSExecutor extends BasePage{

    JavascriptExecutor js;

    public JSExecutor(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public JSExecutor enterDataWithJSE(String name, String password) {
        if (name != null && password != null) {
            js.executeScript("document.getElementById('username').value='" + name + "';");
            js.executeScript("document.getElementById('password').value='" + password + "';");
            js.executeScript("document.getElementById('password').style.border = '3px solid red';");
        }
        return this;
    }

    public JSExecutor clickOnLoginButtonWithJSE() {
        js.executeScript("document.querySelector('.radius').click();");
        return this;
    }

    public JSExecutor checkURLWithJSE() {
        String URL = js.executeScript("return document.URL;").toString();
        System.out.println("URL if the site: " + URL);
        return this;
    }
}

/*
refresh page - "history.go(0);" -
return all text - "return document.documentElement.innerText;"
navigate to new page = "window.location = 'https://demoqa.com';"
return title of page - "return document.title;"
* */
