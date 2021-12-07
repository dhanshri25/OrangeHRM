package exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class OrangeHRM {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Invoke the browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DHVITTHA\\eclipse-workspace\\Selenium\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//get the url
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		//login
		FileInputStream fs = new FileInputStream("C:\\Users\\DHVITTHA\\eclipse-workspace\\Selenium\\src\\exercise\\Properties\\OrangeHRMLogin.Properties");
		Properties prop = new Properties();
		prop.load(fs);
		String username = prop.getProperty("Username");
		String password = prop.getProperty("Password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
        
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        
        //select Admin button
        driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
        driver.findElement(By.xpath("//body[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[4]")).click();
        
        //select skills
        driver.findElement(By.xpath("//a[@id='menu_admin_viewSkills']")).click();
        
        //add skills
        String Name = prop.getProperty("Name");
        String Description = prop.getProperty("Description");
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        driver.findElement(By.xpath("//input[@id='skill_name']")).sendKeys(Name);
        driver.findElement(By.xpath("//textarea[@id='skill_description']")).sendKeys(Description);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        
        //take screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src, new File("C:\\Users\\DHVITTHA\\eclipse-workspace\\Selenium\\Screenshot"+" SKILL "+ ".png"));
        
        //delete skill
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).click();
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        Thread.sleep(3000);
        
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr/td[@class='tdName tdValue']"));
        for(WebElement skill : rows)
        {
        	if(skill.getText()!="Automation Testing")
        	{
        		System.out.println("Automation Testing skill not found");
        		break;
        		
        	}
        }
        
        driver.close();
	}
}