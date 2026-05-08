package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotProvider {
	
	public static String captureScreenshot(WebDriver driver, String testname) {
		
		String path = "./Screenshot/SS1_"+getTimeStamp() +".png";
		TakesScreenshot ts= (TakesScreenshot) driver;
		try {
			FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(path));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to Capture Screenshot " + e.getMessage());
		} 
		return path;
	}
	
	public static String getTimeStamp() {
		String timestamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		return timestamp;
	}

}
