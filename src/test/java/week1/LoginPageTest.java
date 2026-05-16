package week1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass{
	
	@Test(priority=1)
	public void loginWithValid() {
		
		test=reports.createTest("TC_LOGIN_001");
		test.info("Entering the Credentials");
		page.login("Admin", "admin123");
		test.info("Clicked Login Button");
		wait.elementUrlContains("dashboard");
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard/index"));
		
	}
	
	@Test(priority=2)
	public void loginWithInvalid() {
		test=reports.createTest("TC_LOGIN_002");
		test.info("Entering the Credentials");
		page.login("Admin", "admin12");
		test.info("Clicked Login Button");
		
		Assert.assertEquals(page.getInvalidMsg(),"Invalid credentials");
	}


}
