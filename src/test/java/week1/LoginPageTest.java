package week1;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelWithDataProvider;

public class LoginPageTest extends BaseClass{
	
	@Test(priority=1, dataProvider="ExcelData",dataProviderClass = ExcelWithDataProvider.class)
	public void loginWithValid(String u, String p) {
		
		test=reports.createTest("TC_LOGIN_001");
		test.info("Entering the Credentials");
		page.login(u,p);
		test.info("Clicked Login Button");
		wait.elementUrlContains("dashboard");
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard/index"));
		
	}
	
	@Test(priority=2,enabled=false)
	public void loginWithInvalid() {
		test=reports.createTest("TC_LOGIN_002");
		test.info("Entering the Credentials");
		page.login("Admin", "admin12");
		test.info("Clicked Login Button");
		
		Assert.assertEquals(page.getInvalidMsg(),"Invalid credentials");
	}


}
