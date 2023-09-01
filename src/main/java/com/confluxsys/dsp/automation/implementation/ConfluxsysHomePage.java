package com.confluxsys.dsp.automation.implementation;

import com.aventstack.extentreports.Status;
import com.confluxsys.dsp.automation.utills.Config;
import com.confluxsys.dsp.automation.objectRepository.Homepage;
import com.confluxsys.dsp.automation.utills.Initialization;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ConfluxsysHomePage extends Initialization implements Config,Homepage
{
    public void verifyHomePage()
    {
        logger.log(Status.INFO,"Verifying the homepage Title");
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply( WebDriver driver) {
                return driver.getCurrentUrl().equals(homePageLink);
            }
        });
        String homepage=driver.getCurrentUrl();
        softAssert.assertEquals(homePageLink,homepage,"Self service Home page links are not matching");
    }

    public void clickUarAdministrationLink()  {
        logger.log(Status.INFO,"Step- click UAR Administration Link");
        getWebElement("XPATH",uarAdministrationPortalLink).click();
    }
}
