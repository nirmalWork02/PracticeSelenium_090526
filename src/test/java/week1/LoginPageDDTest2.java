package week1;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.ExcelWithDataProvider;

public class LoginPageDDTest2 extends BaseClass {

	@Test(priority = 1, dataProvider = "ExcelData", dataProviderClass = ExcelWithDataProvider.class)
	public void loginWithValid(String username, String password, String expectedResult) {

		test = reports.createTest("TC_LOGIN_001 -" + username +"- " +expectedResult);
		test.info("Entering the Credentials");
		page.login(username, password);
		test.info("Clicked Login Button");
		
		switch(expectedResult.toLowerCase()) {
		case "success":
			wait.elementUrlContains("dashboard");
			Assert.assertTrue(driver.getCurrentUrl().contains("dashboard/index"));
			break;
		
		case "failure":
			sa.assertTrue(page.getInvalidMsg().contains("Invalid"), "Parsed Valid Credentials, Test Will fail");
			break;
			
		case "both_required":
			sa.assertTrue(page.getInerrMsg1().contains("Required"),"No error message observed");
			sa.assertTrue(page.getInerrMsg2().contains("Required"),"No error message observed");
			break;
			
		case "username_required":
			sa.assertTrue(page.getInerrMsg1().contains("Required"),"No error message observed");
			break;
			
		case "password_required":
			sa.assertTrue(page.getInerrMsg2().contains("Required"),"No error message observed");
			break;
			
		default:
			System.out.print("Invalid, Enter success or failure");
		}
		sa.assertAll();
		/*if (expectedResult.equalsIgnoreCase("success")) {
			
		} else if (expectedResult.equalsIgnoreCase("failure")) {
			
		} 
		else if (expectedResult.equalsIgnoreCase("both_required"))
		{
			
		}	
		else if (expectedResult.equalsIgnoreCase("username_required"))
		{
			
		}	
		else if (expectedResult.equalsIgnoreCase("password_required"))
		{
			
		}	
		
		else {
		
			
		}*/
		
	}

}
