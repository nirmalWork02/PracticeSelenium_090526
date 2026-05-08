package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	
	public static WebDriver browser(String browserName) {
	    WebDriver driver;

	    if (browserName.equalsIgnoreCase("chrome")) {
	        driver = new ChromeDriver();
	    } else if (browserName.equalsIgnoreCase("firefox")) {
	        driver = new FirefoxDriver();
	    } else {
	        throw new IllegalArgumentException("Invalid browser name: " + browserName);
	    }

	    driver.manage().window().maximize();
	    return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		if(driver!=null) {
			driver.quit();
		}
		
	}
	
	
	

}
