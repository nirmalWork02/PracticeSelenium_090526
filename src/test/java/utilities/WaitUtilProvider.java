package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilProvider {
	WebDriverWait wait;
	WebDriver driver;
	public  WaitUtilProvider( int timeoutInSeconds, WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(0));
		this.driver = driver;
	}
	
	
	public void elementUrlContains(String text) {
		wait.until(ExpectedConditions.urlContains(text));

	}
	
	public boolean textToBe(By locator,String text) {
		return wait.until(ExpectedConditions.textToBe(locator,text));

	}

}
