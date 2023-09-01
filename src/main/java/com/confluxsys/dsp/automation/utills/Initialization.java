package com.confluxsys.dsp.automation.utills;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.confluxsys.dsp.automation.implementation.SelfServiceLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.markuputils.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.asserts.SoftAssert;

public class Initialization implements Config {
    public static WebDriver driver;
    public ExtentSparkReporter sparkReporter;
    public  ExtentReports extent;
    public static ExtentTest logger;
    public static SoftAssert softAssert;
   public static  WebDriverWait wait;
   public static int i=0;

    public void launch_browser()
    {
        if(Browser.equalsIgnoreCase("Chrome")) {
        //    WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Confluxsys\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions o= new ChromeOptions();
            o.addArguments("−−incognito");
            driver = new ChromeDriver(o);
        }
        else if (Browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else if(Browser.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(homePageLink);
        logger.log(Status.INFO,"Launching website:"+driver.getCurrentUrl());
        softAssert=new SoftAssert();
        wait=new WebDriverWait(driver,20);
    }

    public WebElement getWebElement(String identifierType, String identifierValue)
    {
        switch (identifierType)
        {
            case "XPATH":
                return driver.findElement(By.xpath(identifierValue));
            case "CSS":
                return driver.findElement(By.cssSelector(identifierValue));
            case "ID":
                return driver.findElement(By.id(identifierValue));
            case "NAME":
                return driver.findElement(By.name(identifierValue));
            case "TAGNAME":
                return driver.findElement(By.tagName(identifierValue));
            case "CLASSNAME":
                return driver.findElement(By.className(identifierValue));
            case "LINKTEXT":
                return driver.findElement(By.linkText(identifierValue));
            default:
                return null;
        }
    }
    public List<WebElement> getWebElements(String identifierType, String identifierValue)
    {
        switch (identifierType)
        {
            case "XPATH":
                return driver.findElements(By.xpath(identifierValue));
            case "CSS":
                return driver.findElements(By.cssSelector(identifierValue));
            case "ID":
                return driver.findElements(By.id(identifierValue));
            case "NAME":
                return driver.findElements(By.name(identifierValue));
            case "TAGNAME":
                return driver.findElements(By.tagName(identifierValue));
            case "CLASSNAME":
                return driver.findElements(By.className(identifierValue));
            case "LINKTEXT":
                return driver.findElements(By.linkText(identifierValue));
            default:
                return null;
        }
    }
    public void quite_browser()
    {
        logger.log(Status.INFO,"Closing the browser window");
        driver.quit();
    }


    //@BeforeTest
    @BeforeClass
    public void generateReport()
    {//dynamic report genaration for each different <test> tag of testng.xml
        i++;
        System.out.println("value of i:="+ i);
        if(i!=0) {

            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "Report" + File.separator + "Report_"+i+".html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("AutomationReport");
            sparkReporter.config().setReportName("Automation test Results");

        }
    }

    @BeforeMethod
    public void launchBrowser(Method testMethod) throws InterruptedException {
        Test test= testMethod.getAnnotation(Test.class);
        logger=extent.createTest("Test case:-"+test.testName()+"<br>Description:-"+test.description());
        SelfServiceLoginPage objSelfServiceLoginPage=new SelfServiceLoginPage();
        launch_browser();
        objSelfServiceLoginPage.EnterUsernameAndPassword();
        objSelfServiceLoginPage.clickLoginButton();
    }
    @AfterMethod
    public void afterMethod(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+" - Test case Failed", ExtentColor.RED));
            logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+" - Test case Failed",ExtentColor.RED));
        }
        else if(result.getStatus() == ITestResult.SKIP)
        {
            logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+" - Test case Skipped", ExtentColor.ORANGE));
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(Status.PASS,MarkupHelper.createLabel(result.getName()+" - Test case Passed", ExtentColor.GREEN));
        }
        logger.log(Status.INFO,MarkupHelper.createLabel(result.getTestClass().getName()+" - Test Class Name", ExtentColor.ORANGE));
        quite_browser();
    }
   //@AfterTest
    @AfterClass
    public void afterTest()
    {
        softAssert.assertAll();
        extent.flush();
    }



}
