package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jsExecutor;
    Actions actions;

    public Page(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver,15);
        this.jsExecutor = (JavascriptExecutor)driver;
        this.actions = new Actions(driver);
    }

    //abstract methods
    public abstract String getPageTitle();
    public abstract WebElement getElement(By locator);
    public abstract void waitForElementPresent(By locator);
    public abstract boolean waitForJSandJQueryToLoad();

}
