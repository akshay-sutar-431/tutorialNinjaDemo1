package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;
import java.io.IOException;

public class Listeners extends Base implements ITestListener {

    WebDriver driver = null;
    ExtentReports extentReport = ExtentReporter1.getExtentReport();
    ExtentTest extentTest;
    ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<ExtentTest>();


    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        extentTest = extentReport.createTest(testName+" execution started");
        extentTestThreadLocal.set(extentTest);

    }

    public void onTestSuccess(ITestResult result) {
        //extentTest.log(Status.PASS, result.getName()+" got passed");
        extentTestThreadLocal.get().log(Status.PASS, result.getName()+" got passed");
        //extentTestThreadLocal.set(extentTest);
    }

    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        extentTest.log(Status.FAIL, testName+ " failed");
        extentTestThreadLocal.set(extentTest);
        //WebDriver driver = null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            String scPath = takeScreenshot(testName,driver);
            extentTestThreadLocal.get().addScreenCaptureFromPath(scPath, testName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {
        extentReport.flush();
    }
}
