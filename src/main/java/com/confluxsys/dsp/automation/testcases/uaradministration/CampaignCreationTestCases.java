package com.confluxsys.dsp.automation.testcases.uaradministration;

import com.aventstack.extentreports.Status;
import com.confluxsys.dsp.automation.implementation.ConfluxsysHomePage;
import com.confluxsys.dsp.automation.implementation.UarAdministrationCertificationDashboardPage;
import com.confluxsys.dsp.automation.utills.Initialization;
import org.testng.annotations.Test;

public class CampaignCreationTestCases extends Initialization
{
    UarAdministrationCertificationDashboardPage objuarPage=new UarAdministrationCertificationDashboardPage();
    ConfluxsysHomePage objConfluxsysHomePage=new ConfluxsysHomePage();

    @Test(priority = 1,testName = "Create campaign E2E Flow", description = "Create campaign End to end flow")
    public void Create_Campaign_E2E() throws InterruptedException {
        objConfluxsysHomePage.verifyHomePage();
        objConfluxsysHomePage.clickUarAdministrationLink();
        logger.log(Status.INFO,"Verify the certification Dashboard title");
        objuarPage.verifyCertificationDashboardTitle();
        logger.log(Status.INFO,"Step- Create Campaign");
        objuarPage.createCampaignMethod();
    }
    @Test(priority = 2,testName = "Create campaign 2", description = "test campaign create 2")
    public void fun2()
    {
        logger.log(Status.INFO,"fun 2");
        objConfluxsysHomePage.clickUarAdministrationLink();
        objuarPage.demo_test_fail_fun();
    }
    @Test(priority = 3,testName = "Create campaign 3", description = "test campaign create 2")
    public void fun3()
    {
        logger.log(Status.INFO,"fun 3");
    }
}

