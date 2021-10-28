package io.codification;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.ConfigLoader;
import utils.ExtentReportUtils;

import static io.restassured.RestAssured.*;

public class BaseTest {

    String currentWorkingDirectory;

    String htmlReportName;

    String htmlReportFilePath;

    ExtentReportUtils reportUtils;

    @BeforeClass
    public void setup() {

        baseURI = ConfigLoader.getInstance().baseUrl();

        port = ConfigLoader.getInstance().portNumber();

        currentWorkingDirectory = System.getProperty("user.dir");

        htmlReportName = ConfigLoader.getInstance().reportName();

        htmlReportFilePath = String.format("%s/reports/", currentWorkingDirectory);

        String filename = htmlReportFilePath + "/" + htmlReportName;

        reportUtils = new ExtentReportUtils(filename);
    }

    @AfterClass
    public void cleanUp(){

        reportUtils.closeReport();

    }
    
}
