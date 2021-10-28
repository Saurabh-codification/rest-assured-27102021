package utils;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportUtils {

    private ExtentHtmlReporter htmlReporter;

    private ExtentReports extentReporter;

    private ExtentTest extentTest;

    public ExtentReportUtils(String filename){

        htmlReporter = new ExtentHtmlReporter(filename);
        extentReporter = new ExtentReports();
        extentReporter.attachReporter(htmlReporter);
    }


    public void createTestCase(String testCaseName) {

        extentTest = extentReporter.createTest(testCaseName);
    }

    public void addLog(Status status, String comment){

        extentTest.log(status, comment);
    }

    public void closeReport(){
        extentReporter.flush();
    }
    
}
