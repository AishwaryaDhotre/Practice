package com.confluxsys.dsp.automation.implementation;

import com.aventstack.extentreports.Status;
import com.confluxsys.dsp.automation.utills.AssertStatements;
import com.confluxsys.dsp.automation.utills.Initialization;
import com.confluxsys.dsp.automation.objectRepository.UarAdministration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class UarAdministrationCertificationDashboardPage extends Initialization implements UarAdministration
{
    static String date;
    AssertStatements objAssert=new AssertStatements();
    public void verifyCertificationDashboardTitle() {
        // wait.until(ExpectedConditions.visibilityOf(getWebElement("XPATH",uarDashboardTitle)));
        objAssert.waitForElementPresentBy_Xpath("XPATH",uarDashboardTitle);
        String dashboardName=getWebElement("XPATH",uarDashboardTitle).getText();
        softAssert.assertEquals(dashboardName,certificationDashboard,"Dashboard title not matching");

    }

    public void demo_test_fail_fun()
    {
        Assert.assertTrue(getWebElements("XPATH",actionButton).size()==0,"Element not found");
    }
    public void createCampaignMethod() throws InterruptedException {
        logger.log(Status.INFO,"Step- Clicking the create button");
//wait.until(ExpectedConditions.visibilityOf(getWebElement("XPATH",createButton)));
        objAssert.waitForElementPresentBy_Xpath("XPATH",createButton);
        Thread.sleep(3000);
        getWebElement("XPATH",createButton).click();
        logger.log(Status.INFO,"Step- Passing the Campaign Name in CampaignName Text Field");
        getWebElement("XPATH",campaignNameField).sendKeys(campaigName);
        Thread.sleep(3000);
        logger.log(Status.INFO,"Step- Entered Cmapign Name:DSP Automation Camp_1");
        logger.log(Status.INFO,"Step- Passing the Campaign description in CampaignDescription Text Field");
        getWebElement("XPATH",campaignDescriptionField).sendKeys(new CharSequence[]{"Test demo Purpose"});
        logger.log(Status.INFO,"Step- Clicking the search button");
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.visibilityOf(getWebElement("XPATH",searchButton)));
        objAssert.waitForElementPresentBy_Xpath("XPATH",searchButton);
        getWebElement("XPATH",searchButton).click();
        List<WebElement> List_ProgramName=getWebElements("XPATH",li_programName);
        Iterator var2 = List_ProgramName.iterator();

        while(var2.hasNext()) {
            WebElement el = (WebElement)var2.next();
            if (el.getText().equalsIgnoreCase("Annual Access Revalidation")) {
                String ProgramName = el.getText();
                logger.log(Status.INFO,"Step- Choosen Program Name:" + ProgramName);
                el.click();
                break;
            }
        }

        logger.log(Status.INFO,"Step- Clicking the submit button");
        // wait.until(ExpectedConditions.visibilityOf(getWebElement("XPATH",submitButton)));
        objAssert.waitForElementPresentBy_Xpath("XPATH",submitButton);
        getWebElement("XPATH",submitButton).click();
        logger.log(Status.INFO,"Step- Capturing the alert message");
        objAssert.waitForElementPresentBy_Xpath("XPATH",confirmationBox);
        String msg = getWebElement("XPATH",confirmDataAlert).getText();
        logger.log(Status.INFO,"Step- Captured Alert Message" + msg);
        logger.log(Status.INFO,"Step- Clicking the confirm button of Alert Box");
        getWebElement("XPATH",alertConfirmButton).click();
        Thread.sleep(3000);
        logger.log(Status.INFO,"Capture the created campaign timestamp details");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        date = dtf.format(now);
        logger.log(Status.INFO,"Campaign Creation time:" + dtf.format(now));
        Thread.sleep(5000);
    }

}
