package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplyNowPage extends BasePage{

    //private page locators
    private By applyButton = By.id("indeedApplyButton");

    public ApplyNowPage(WebDriver driver) {
        super(driver);
    }

    //public getter methods
    public WebElement getApplyButton() {
        return getElement(applyButton);
    }

    //page actions
    public LoginPage doApply(){

        getApplyButton().click();

        return getInstance(LoginPage.class);
    }
}
