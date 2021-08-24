package com.tests;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.pages.BasePage;
import com.pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    public Page page;
    ATUTestRecorder recorder;

    public String propBaseURL;
    public String propUsername;
    public String propPassword;

    //method that runs before test execution
    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUpTest(String browser) throws Exception {

        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
        Date date = new Date();

        //create ATUTestRecorder object & provide path to store videos and file name format.
        recorder = new ATUTestRecorder("C:\\Users\\Farid Ouedraogo\\Documents\\selenium videos","TestVideo-"+dateFormat.format(date),false);
        //start video recording.
        recorder.start();

        //create WebDriver instance
        if(browser.equals("chrome")){

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
//            options.addArguments("--disable-web-security");
//            options.addArguments("--allow-running-insecure-content");
//            options.addArguments("--user-data-dir=C:\\Users\\Farid Ouedraogo\\AppData\\Local\\Google\\Chrome\\User Data\\Default");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

        } else if(browser.equals("firefox")){

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        } else{
            System.out.println("no browser is defined in the POM.xml file.");
        }

        //load properties file
        Properties prop = new Properties();
        FileInputStream propertyFile = new FileInputStream("src\\main\\resources\\config.properties");
        prop.load(propertyFile);

        //set properties
        String propBaseURL = prop.getProperty("baseURL");
        String propUsername = prop.getProperty("username");
        String propPassword = prop.getProperty("password");

        try{
            System.out.println("Connecting to base-url: " + propBaseURL);
            driver.get(propBaseURL);        }
        catch (Exception e){
            e.printStackTrace();
        }

        page = new BasePage(driver);

    }

    //method that runs after test execution
    @AfterMethod
    public void tearDown(){
        try{
            Thread.sleep(5000);
            driver.quit();
            //stop video recording.
            recorder.stop();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
