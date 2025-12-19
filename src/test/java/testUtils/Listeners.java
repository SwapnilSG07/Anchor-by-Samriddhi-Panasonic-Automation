package testUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import utils.AppiumUtils;

public class Listeners extends AppiumUtils implements ITestListener {

    // ✅ No-argument constructor for TestNG
    public Listeners() {
        super(); // Calls AppiumUtils default constructor
    }

    private ExtentTest test;
    private AppiumDriver driver;

    // ✅ Get ExtentReports instance from static method
    private ExtentReports extent = ExtentReporterNG.getReporterObject();

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("LISTENER STARTED");
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());

        // ✅ Get driver instance from the test class
        try {
            driver = (AppiumDriver) result.getTestClass().getRealClass()
                    .getField("driver")
                    .get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ✅ Capture screenshot on failure and attach to report
        try {
            String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("LISTENER FINISHED");
        extent.flush();
    }

    // ✅ Utility method to capture screenshot
    public String captureScreenshot(String methodName) throws IOException {
        String reportDir = System.getProperty("user.dir") + "/reports/screenshots";
        new File(reportDir).mkdirs(); // create folder if not exists

        String screenshotPath = reportDir + "/" + methodName + ".png";

        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotPath);
        Files.copy(srcFile.toPath(), destFile.toPath());

        return screenshotPath; // return path to attach in ExtentReports
    }
}
