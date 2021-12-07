package OrangeHRMPom;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HRMtestcase_POM {
	
	public HRMtestcase_POM()
	{
		
	}
	
	WebDriver driver = null;
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DHVITTHA\\eclipse-workspace\\Selenium\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void Login() throws IOException, InterruptedException
	{
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		HRMlogin_POM h = new HRMlogin_POM(driver);
		HRMskill_POM a = new HRMskill_POM(driver);
		HRMskillverification_POM b = new HRMskillverification_POM(driver);
		h.LoginFunc();
		a.navigate();
		a.skillAdd();
		b.add_verify();
		Thread.sleep(1000);
		a.screenshot();
		a.skillDel();
		Thread.sleep(2000);
		b.del_verify();
		
		
		driver.close();
	}

}

