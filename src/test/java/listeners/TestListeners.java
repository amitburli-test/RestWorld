package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;

public class TestListeners implements ITestListener {
    Logger logger = LogManager.getLogger(TestListeners.class);

    public ExtentSparkReporter sparkReproter;
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext context) {
        logger.info("Test suit started..!" + context.getStartDate());
        sparkReproter = new ExtentSparkReporter("./reports/myreprot1.html");
        sparkReproter.config().setDocumentTitle("Automation report");
        sparkReproter.config().setReportName("Auth Api Testing");
        sparkReproter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReproter);
        extent.setSystemInfo("env", "qa");
        extent.setSystemInfo("testerName", "Amit Burli");
    }

    public void onTestStart(ITestResult result) {
        logger.info("test started..! " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.debug("test passed..!" + result.getName());
        logger.debug("test description..!" + result.getMethod().getDescription());
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "test passed " + result.getName());
        test.log(Status.PASS, "test passed " + result.getTestName());
        test.log(Status.PASS, "test passed " + result.getMethod());
        test.getStatus();
    }

    public void onTestFailure(ITestResult result) {
        logger.error("test failed..!" + result.getName());
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test failed " + result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("test skipped..!" + result.getName());
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test Skipped " + result.getName());
    }

    public void onFinish(ITestContext context) {
        logger.info("Test suit complited..!" + context.getStartDate());
        extent.flush();
    }
}