package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    //private page locators
    private By email = By.id("login-email-input");
    private By password = By.id("login-password-input");
    private By loginButton = By.id("login-submit-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //public getter methods
    public WebElement getEmail() {
        return getElement(email);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLoginButton() {
        return getElement(loginButton);
    }

    //public page actions
    public void doLogin(String username, String password){
        getEmail().sendKeys(username);
        getPassword().sendKeys(password);
        getLoginButton().click();
    }


}
