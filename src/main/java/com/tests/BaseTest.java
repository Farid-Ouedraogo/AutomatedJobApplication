package com.tests;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.log4j.Logger;


public class BaseTest {
    WebDriver driver;
    public Page page;
    public Logger log;
    ATUTestRecorder recorder;

    //define public property variables
    public String baseURL;
    public String username;
    public String password;

    //method that runs before test execution
    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUpTest(String browser) throws Exception {

        //load properties file
        setUpProperties();

        //set up test recorder
        setUpTestRecorder();

        //create WebDriver instance
        if(browser.equals("chrome")){

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(setUpChromeOptions());

        } else if(browser.equals("firefox")){

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        } else{
            System.out.println("no browser is defined in the testng.xml file.");
        }

        //load properties file
        Properties prop = new Properties();
        FileInputStream propertyFile = new FileInputStream("src\\main\\resources\\config.properties");
        prop.load(propertyFile);

        //start video recording.
        recorder.start();

        try{
            System.out.println("Connecting to base-url: " + baseURL);
            driver.get(baseURL);        }
        catch (Exception e){
            e.printStackTrace();
        }

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

    //method to load properties file
    public void setUpProperties() throws Exception {

        //load properties file
        Properties prop = new Properties();
        FileInputStream propertyFile = new FileInputStream("src\\main\\resources\\config.properties");
        prop.load(propertyFile);

        //set properties
        baseURL = prop.getProperty("baseURL");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
    }

    //method to set chrome properties
    public ChromeOptions setUpChromeOptions(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        return options;
    }

    //method to set up test recorder
    public void setUpTestRecorder() throws ATUTestRecorderException {

        //date format to append to video title
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH-mm-ss");
        Date date = new Date();

        //path to store videos and file name format
        recorder = new ATUTestRecorder("recordings\\","Test Case - "+dateFormat.format(date),false);
    }


}
