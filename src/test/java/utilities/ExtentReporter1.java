package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter1 {
    public static ExtentReports extentReport;
    static ExtentReports report;

    public static ExtentReports getExtentReport()
    {
        //String path = System.getProperty("user.dir")+"\\reports\\ExtentReportResults.html";
        //report = new ExtentReports();
        extentReport = new ExtentReports();

        String extentReportPath = System.getProperty("user.dir")+"\\reports\\report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
        reporter.config().setReportName("TutorialNinja Automation Reports");
        reporter.config().setDocumentTitle("Test Results");


        extentReport.attachReporter(reporter);
        extentReport.setSystemInfo("Operating System", "Windows 10");
        extentReport.setSystemInfo("Tested By", "Akshay");

        return extentReport;
    }
}
