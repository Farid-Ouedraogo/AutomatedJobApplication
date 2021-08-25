package com.tests;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;


public class ApplyToJobTest extends BaseTest{

    public ApplyNowPage applyNowPage ;
    public LoginPage loginPage ;
    public ResumePage resumePage;

    @Test(priority = 1)
    public void doLoginTest() throws InterruptedException {

        log = Logger.getLogger("ApplyToJobTest");

        //pass driver to login page
        applyNowPage = new ApplyNowPage(driver);

        //access the job application page and assert the page title
        String applyNowPageTitle = applyNowPage.getPageTitle();
        System.out.println(applyNowPageTitle);
        Assert.assertEquals(applyNowPageTitle, "Quality Assurance Automation Engineer - Profile - Remote - Indeed.com");
        log.info("verified job application page title");

        //click the apply button
        applyNowPage.doApply();

        //pass driver to login page
        loginPage = new LoginPage(driver);

        //assert the "Sign In" page title
        String loginPageTitle = loginPage.getPageTitle();
        System.out.println(loginPageTitle);
        Assert.assertEquals(loginPageTitle,"Sign In | Indeed Accounts");
        log.info("verified sign in page title");


        //login using the username and password properties
        loginPage.doLogin(username,password);

        //pass driver to the resume page
        resumePage = new ResumePage(driver);

        //select resume and answer form questions.
        resumePage.doFillOutApplicationForm();
        log.info("test complete");

    }

}
