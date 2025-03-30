package com.fastfoodfinder.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class BaseTest {

    protected final Duration TIMEOUT = Duration.ofSeconds(10);

    protected static ExtentReports extent;
    protected ExtentTest test;
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void setupExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554")
                .setApp("D:\\Dev\\locator-app.apk")
                .setAutomationName("UiAutomator2")
                .autoGrantPermissions()
                .disableWindowAnimation();

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.manage().timeouts().implicitlyWait(TIMEOUT);

        wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.TextView")));
    }

    @BeforeMethod
    public void startTest(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @AfterMethod
    public void captureScreenshotOnTestFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File screenshot = driver.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = testResult.getName() + "_" + timestamp + ".png";
            Path destination = Path.of("screenshots", fileName);

            try {
                Files.createDirectories(destination.getParent());
                Files.copy(screenshot.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Screenshot could not be captured");
            }
        }
    }

    @AfterMethod
    public void tearDownTest() {
        extent.flush();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void closeExtent() {
        extent.flush();
    }
}
