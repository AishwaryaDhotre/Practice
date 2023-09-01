package com.confluxsys.dsp.automation.testcases.uaradministration;

import com.aventstack.extentreports.Status;
import com.confluxsys.dsp.automation.implementation.ConfluxsysHomePage;
import com.confluxsys.dsp.automation.utills.Initialization;
import org.testng.annotations.*;

public class HomePageTestCases extends Initialization
{
   // SelfServiceLoginPage objSelfserviceLoginPage =new SelfServiceLoginPage();
    ConfluxsysHomePage objConfluxsysHomePage=new ConfluxsysHomePage();
 /*   @BeforeMethod
    public void browserLaunchMethod() throws InterruptedException {
        launch_browser();
        objSelfserviceLoginPage.EnterUsernameAndPassword();
        objSelfserviceLoginPage.clickLoginButton();
    }*/
    @Test(priority = 1,testName = "Redirect to the Home Page", description = "Perform login & redirect to homepage")
    public void redirectToUarAdministration()  {
        logger.log(Status.INFO,"Verifying the Home page Link");
        objConfluxsysHomePage.verifyHomePage();
        logger.log(Status.INFO,"Step- Click UAR Administration link");
        objConfluxsysHomePage.clickUarAdministrationLink();
    }
    @Test(priority = 2,testName = "demo 1", description = "description 1")
    public void demo1()
    {
        logger.log(Status.INFO,"function 1");
    }
    @Test(priority = 3,testName = "demo 2", description = "description 2")
    public void demo2()
    {
        logger.log(Status.INFO,"function 2");
    }
  /* @AfterTest
    public void closeBrowser()
    {
        quite_browser();
    }
*/
}
