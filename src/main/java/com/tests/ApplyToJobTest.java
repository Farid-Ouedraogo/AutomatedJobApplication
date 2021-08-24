package com.tests;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplyToJobTest extends BaseTest{

    @Test(priority = 1)
    public void doLoginTest() throws InterruptedException {

        //Open job application page and assert/confirm the page title
        String applyNowPageTitle = page.getInstance(ApplyNowPage.class).getPageTitle();
        System.out.println(applyNowPageTitle);
        Assert.assertEquals(applyNowPageTitle, "Quality Assurance Automation Engineer - Profile - Remote - Indeed.com");

        //Click the apply button and assert/confirm that you are redirected to the "Sign In" page
        LoginPage loginPage = page.getInstance(ApplyNowPage.class).doApply();
        String loginPageTitle = loginPage.getPageTitle();
        System.out.println(loginPageTitle);
        Assert.assertEquals(loginPageTitle,"Sign In | Indeed Accounts");

        //Enter username & password then click the "Sign In" button
        ResumePage resumePage = page.getInstance(LoginPage.class).doLogin("username","password");
        String resumePageTitle = resumePage.getPageTitle();
        System.out.println(resumePageTitle);
        Assert.assertEquals(resumePageTitle,"Upload or create a resume for this application | Indeed.com");

        //Select to use existing resume and fill out form questions.
         page.getInstance(ResumePage.class).doFillOutApplicationForm();
    }

}
