package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver,this);
		 wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	@FindBy(how=How.XPATH, using = "//input[contains(@name,'username')]")
	WebElement username;
	
	@FindBy(how=How.CSS, using ="input[name='password']")
	WebElement password;
	
	@FindBy(how=How.XPATH, using="//button[contains(@type,'submit')]")
	WebElement btn_Login;
	
	@FindBy(how=How.XPATH, using="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement err_msg;
	
	@FindBy(how=How.XPATH, using="(//span[text()='Required'])[1]")
	WebElement inline_errMsg1;
	
	@FindBy(how=How.XPATH, using="//span[text()='Required']")
	WebElement inline_errMsg2;
	
	@FindBy(how=How.CSS, using=".oxd-text.oxd-text--p.orangehrm-login-forgot-header")
	WebElement frgtPass;
	
	public void login(String user, String pass) {
		wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(user);
        password.sendKeys(pass);
        btn_Login.click();
    }
	
	public String getInvalidMsg() {
		wait.until(ExpectedConditions.visibilityOf(err_msg));
		return err_msg.getText();
	}
	public String getInerrMsg1() {
		wait.until(ExpectedConditions.visibilityOf(inline_errMsg1));
		return inline_errMsg1.getText();
	}
	
	public String getInerrMsg2() {
		wait.until(ExpectedConditions.visibilityOf(inline_errMsg2));
		return inline_errMsg2.getText();
	}
	public void clickFrgtPassword() {
		frgtPass.click();
	}

}
