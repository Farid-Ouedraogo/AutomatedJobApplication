package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ResumePage extends BasePage {

    //private page locators
    private By savedResumeButton = By.id("resume-display-buttonHeader");
    private By continueButton = By.xpath("//span[contains(text(),'Continue')]");
    private By reviewButton = By.xpath("//span[contains(text(),'Review your application')]");
    private By exitButton = By.xpath("//span[contains(text(),'Exit')]");
    private By ethnicityOption = By.xpath("//select[@id='input-q_6f93d01670cd1033affc62047021c9c6']");
    private By genderOption = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/fieldset[1]/label[2]/input[1]");
    private By veteranOption = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/fieldset[1]/label[2]/input[1]");
    private By disabilityOption = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/label[2]/input[1]");
    private By jobAlertCheckbox = By.id("ia-JobAlert-makeJobAlert");


    public ResumePage(WebDriver driver) {
        super(driver);
    }

    //public page getters
    public WebElement getSavedResumeButton() {
        return getElement(savedResumeButton);
    }

    public WebElement getContinueButton() {
        return getElement(continueButton);
    }

    public WebElement getReviewButton() {
        return getElement(reviewButton);
    }

    public WebElement getExitButton() {
        return getElement(exitButton);
    }

    public WebElement getEthnicityOption() {
        return getElement(ethnicityOption);
    }

    public WebElement getGenderOption() {
        return getElement(genderOption);
    }

    public WebElement getVeteranOption() {
        return getElement(veteranOption);
    }

    public WebElement getDisabilityOption() {
        return getElement(disabilityOption);
    }

    public WebElement getJobAlertCheckbox() {
        return getElement(jobAlertCheckbox);
    }

    //public page actions
    public void doFillOutApplicationForm() throws InterruptedException {
        getSavedResumeButton().click();

        jsExecutor.executeScript("arguments[0].scrollIntoView()", getContinueButton());
        getContinueButton().click();

        Select ethnicitySelect = new Select(getEthnicityOption());
        ethnicitySelect.selectByIndex(3);

        jsExecutor.executeScript("arguments[0].click()", getGenderOption());
        jsExecutor.executeScript("arguments[0].scrollIntoView()", getVeteranOption());
        jsExecutor.executeScript("arguments[0].click()", getVeteranOption());
        getContinueButton().click();

        jsExecutor.executeScript("arguments[0].scrollIntoView()", getDisabilityOption());
        jsExecutor.executeScript("arguments[0].click()", getDisabilityOption());
        getContinueButton().click();
        getReviewButton().click();

        Thread.sleep(5000);

        jsExecutor.executeScript("arguments[0].scrollIntoView()", getJobAlertCheckbox());
        jsExecutor.executeScript("arguments[0].click()", getJobAlertCheckbox());
//        getExitButton().click();

    }

}
