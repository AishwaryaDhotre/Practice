package com.confluxsys.dsp.automation.testcases.accessreview;

import com.aventstack.extentreports.Status;
import com.confluxsys.dsp.automation.utills.Initialization;
import org.testng.annotations.Test;

public class DemoClass_2 extends Initialization {
    @Test(priority = 1,testName = "Function name 1", description = "description 1")
    public void demo1()
    {
        logger.log(Status.INFO,"function 1");
    }
    @Test(priority = 2,testName = "Function name 2", description = "description 2")
    public void demo2()
    {
        logger.log(Status.INFO,"function 2");
    }
}
