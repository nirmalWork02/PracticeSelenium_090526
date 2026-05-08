package week1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.LoginPage;

public class HappyPath extends BaseClass {
	
	LoginPage page; 
	
	@BeforeMethod
	public void loginSetup() {
		page = new LoginPage(driver);
	}
	

	@Test(groups = {"smoke"})
	public void test1() {
		
		test=reports.createTest("Smoke Test").log(Status.PASS, "This is a Positive test case");
		//driver.findElement(By.name("q"));
		System.out.println(driver.getTitle());
		 // Generate report
      

	}
	
	@Test(priority=1,groups = {"Happypath", "regression"})
	public void test2() throws Exception {
		
		/*Open browser Navigate to login page 
		 * Enter valid username 
		 * Enter valid password 
		 * Click Login button*/
		
		test=reports.createTest("Postive Case");
		test.info("Opening Browser");
	
		test.info("Entering Test data");
		page.login(exl.getStringData(0, 0, 0), exl.getStringData(0, 0, 1));
		test.log(Status.PASS, "Successfully Logged");
		
		wait.elementUrlContains("dashboard");
		boolean actualTitle = driver.getCurrentUrl().contains("dashboard/index");
		Assert.assertTrue(actualTitle, "Dashboard URL is not displayed after login.");
		Thread.sleep(Duration.ofSeconds(10));
		
	}
	
	@Test(priority=2,groups= {"regression"})
	public void test3() throws Exception {
		
		/*Open browser Navigate to login page 
		 * Enter valid username 
		 * Enter valid password 
		 * Click Login button*/
		
		test=reports.createTest("Negative Case");
		test.info("Opening Browser");
		
		//Thread.sleep(Duration.ofSeconds(10));
		page.login("Admin", "admin12");
		
		Thread.sleep(Duration.ofSeconds(5));
		wait.textToBe(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"),"Invalid credentials");
		
		Assert.assertTrue(page.getInvalidMsg().contains("Invalid"), "Valid Credentials, Test Will fail");
		Thread.sleep(Duration.ofSeconds(10));
	
	}
	
	@Test
	public void emptyFieldsTest() {
		test=reports.createTest("Testing the Login Page with no testdata");
		test.info("Opening Browser");
		page.login("", "");
		test.info("No Data Entered");
		wait.textToBe(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"), "Required");
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")).getText(), "Required");
	}
		
}
