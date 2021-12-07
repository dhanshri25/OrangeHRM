package OrangeHRMPom;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRMlogin_POM {
WebDriver driver =null;
	
	//create constructor
	public HRMlogin_POM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="txtUsername")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement login;
	
	public void LoginFunc() throws IOException, InterruptedException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\DHVITTHA\\eclipse-workspace\\sample\\src\\main\\java\\OrangeHRMPom\\Properties\\credential.Properties");
		Properties prop = new Properties();
		prop.load(fis);
		username.sendKeys(prop.getProperty("Username"));
		password.sendKeys(prop.getProperty("Password"));
		Thread.sleep(1000);
		login.click();
	}
}
