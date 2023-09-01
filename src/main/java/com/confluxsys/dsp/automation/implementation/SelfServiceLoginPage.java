package com.confluxsys.dsp.automation.implementation;
import com.aventstack.extentreports.Status;
import com.confluxsys.dsp.automation.objectRepository.*;
import com.confluxsys.dsp.automation.utills.Config;
import com.confluxsys.dsp.automation.utills.Initialization;

public class SelfServiceLoginPage extends Initialization implements Config, Login {

    public void EnterUsernameAndPassword()
    {
       // objLoginPage.userName.sendKeys(unameval);
       // objLoginPage.password.sendKeys(passval);
        getWebElement("XPATH", userName).sendKeys(unameval);
        logger.log(Status.INFO,"Step- Entering username");
        getWebElement("XPATH", password).sendKeys(passval);
        logger.log(Status.INFO,"Step- Entering the password");

    }
    public void clickLoginButton()
    {
        logger.log(Status.INFO,"Step- Clicking the Login Button");
        getWebElement("XPATH",loginButton).click();
    }

}
