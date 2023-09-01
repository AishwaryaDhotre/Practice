package com.confluxsys.dsp.automation.utills;

import org.apache.commons.mail.EmailException;
import org.testng.IExecutionListener;

import javax.mail.MessagingException;
import java.io.File;

public class SendReport implements IExecutionListener
{
    public void onExecutionFinish() {
        File currentReportFile = new File(System.getProperty("user.dir")+"\\Report\\Report_1.html");
        if(currentReportFile.isFile()) {
            try {
                SendMailWithAttachment.sendEmailReport();
                //SendMailWithAttachment.sendHTMLEmail();
            } catch (EmailException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
