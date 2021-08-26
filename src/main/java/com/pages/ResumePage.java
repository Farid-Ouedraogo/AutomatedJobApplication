package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ResumePage extends BasePage {

    //private page locators
    private By useSavedResumeButton = By.id("resume-display-buttonHeader");
    private By continueButton = By.xpath("//span[contains(text(),'Continue')]");
    private By reviewButton = By.xpath("//span[contains(text(),'Review your application')]");
    private By exitButton = By.xpath("//span[contains(text(),'Exit')]");
    private By ethnicityOption = By.xpath("//select[@id='input-q_6f93d01670cd1033affc62047021c9c6']");
    private By genderOption = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/fieldset[1]/label[2]/input[1]");
    private By veteranOption = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/fieldset[1]/label[2]/input[1]");
    private By disabilityOption = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/label[2]/input[1]");
    private By coverLetterButton = By.xpath("//span[contains(text(),'Write cover letter')]");
    private By coverLetterText = By.id("coverletter-textarea");
    private By jobAlertCheckbox = By.id("ia-JobAlert-makeJobAlert");
    private By submitButton = By.xpath("//span[contains(text(),'Submit your application')]");


    public ResumePage(WebDriver driver) {
        super(driver);
    }

    //public page getters
    public WebElement getUseSavedResumeButton() {
        return getElement(useSavedResumeButton);
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

    public WebElement getCoverLetterButton() {
        return getElement(coverLetterButton);
    }

    public WebElement getCoverLetterText() {
        return getElement(coverLetterText);
    }

    public WebElement getJobAlertCheckbox() {
        return getElement(jobAlertCheckbox);
    }

    public WebElement getSubmitButton() {
        return getElement(submitButton);
    }


    //public page actions
    public void doFillOutApplicationForm() throws InterruptedException {
        getUseSavedResumeButton().click();
        Thread.sleep(2500);

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
        getCoverLetterButton().click();
        getCoverLetterText().sendKeys("As a current Automation Software Developer, your posting for a new QA Automation Engineer caught \n" +
                "my attention. I believe my skills and experience align well with the qualifications you are seeking at \n" +
                "Indeed. With more than five years of experience in both technical and functional positions at CGI Federal, I am\n" +
                "proficient in Agile development practices, software maintenance, automated testing and quality \n" +
                "assurance. Furthermore, my prior experience as a Business Analyst has given me a well-rounded set of \n" +
                "soft skills to apply in collaborative development environments.\n" +
                "I am passionate about using software to simplify the world we live in, and Indeed's mission to create \n" +
                "products that provide opportunities for all job seekers, like myself, truly excites me. I am certain I would \n" +
                "make a valuable addition to your organization, and would welcome the opportunity to contribute to \n" +
                "your continued success in the employment industry.\n" +
                "Please review my attached resume for additional details regarding my expertise. I am glad to discuss the \n" +
                "position with you at greater length, and look forward to hearing back from you.\n" +
                "Thank you for your time and consideration.");
        Thread.sleep(2000);

//        jsExecutor.executeScript("arguments[0].scrollIntoView()", getReviewButton());
        getReviewButton().click();

        Thread.sleep(4000);

        jsExecutor.executeScript("arguments[0].scrollIntoView()", getJobAlertCheckbox());
        jsExecutor.executeScript("arguments[0].click()", getJobAlertCheckbox());
//        getExitButton().click();
//        getSubmitButton().click();
//        Thread.sleep(7500);
    }

}
