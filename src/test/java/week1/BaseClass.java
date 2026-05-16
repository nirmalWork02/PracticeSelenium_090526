package week1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.LoginPage;
import utilities.BrowserFactory;
import utilities.ConfigProvider;
import utilities.ExcelDataProvider;
import utilities.ScreenshotProvider;
import utilities.WaitUtilProvider;

public class BaseClass {
	
	protected WebDriver driver;
	protected WaitUtilProvider wait;
	protected LoginPage page; 
	
	// Create Reporter
		ExtentSparkReporter spark;
		ExtentReports reports;
		ExtentTest test;
		
	//Configuration
		ConfigProvider con;
	//Excel
		ExcelDataProvider exl;
		
	@BeforeSuite
	public void setupReport() {
		spark =new ExtentSparkReporter("report.html");
		reports = new ExtentReports();
		reports.attachReporter(spark);
		
	}
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		System.out.println("SETUP RUNNING");
		con =new ConfigProvider();
		driver=BrowserFactory.browser(con.getBrowser());
		
		wait=new WaitUtilProvider(30,driver);

	
		driver.get(con.getQaUrl());
		 page = new LoginPage(driver);  
		
		exl = new ExcelDataProvider();
		
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Passed");
		}else if(result.getStatus()==ITestResult.FAILURE) {
			String screenshotpath =ScreenshotProvider.captureScreenshot(driver,result.getTestName());
			test.fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
			//test.log(Status.FAIL, "Test Failed");
			
		}
		
		BrowserFactory.quitBrowser(driver);
		
	}
	
	@AfterSuite
	public void teardownReport() {
		reports.flush();
	}
}
