package week1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataProviderTest extends BaseClass{
	
	@DataProvider
	public Object[][] getData(){
	return new Object[][]	{
		{"Admin", "admin123"}
		
	};
	}
	
	@Test(dataProvider="getData")
	public void login(String user, String pass) {
		test=reports.createTest("TC_LOGIN_001");
		test.info("Entering the Credentials");
		page.login(user,pass);
		test.info("Clicked Login Button");
		wait.elementUrlContains("dashboard");
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard/index"));
		
	}

}
