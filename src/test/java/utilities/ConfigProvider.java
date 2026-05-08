package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigProvider {
	protected Properties pro;
	public ConfigProvider() {
		File src = new File("./Configuration/config.properties");
		
		try {
			
			FileInputStream  fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e){
			throw new RuntimeException ("File not found "+e.getMessage());
			
		}
	}
	
	//create methods for access the field created in properties file
	
	public String getBrowser() {
		return pro.getProperty("browser");
		
	}
	
	public String getQaUrl() {
		return pro.getProperty("qaurl");
		
	}
	
	//Methods to return the random value create after design
	
	public String getKeySearch(String keysearch) {
		return pro.getProperty(keysearch);
	}


}
