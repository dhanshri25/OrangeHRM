package OrangeGrid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class HRMgrid {
	@Test
	@Parameters("browser")
    public void mailTest(String browser) throws IOException, InterruptedException
	{
        DesiredCapabilities dr=null;
        if(browser.equalsIgnoreCase("chrome")){
        dr=DesiredCapabilities.chrome();
        dr.setBrowserName("chrome");
        dr.setPlatform(Platform.WINDOWS);
     
        }
        
        else
        {
            dr=DesiredCapabilities.firefox();
            dr.setBrowserName("firefox");
            dr.setPlatform(Platform.WINDOWS);
        }
             
        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.35:4456/wd/hub"), dr);
		
		//get the url
				driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
				
				//login
				FileInputStream fs = new FileInputStream("C:\\Users\\DHVITTHA\\eclipse-workspace\\sample\\src\\test\\java\\OrangeGrid\\Orange.properties\\grid.properties");
				Properties prop = new Properties();
				prop.load(fs);
				String userid = prop.getProperty("userid");
				String password = prop.getProperty("password");
				driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userid);
		        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		        
		        Thread.sleep(1000);
		        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		        
		        //select Admin button
		        driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("(//a[normalize-space()='Qualifications'])[1]")).click();
		        
		        //select skills
		        driver.findElement(By.xpath("//a[@id='menu_admin_viewSkills']")).click();
		        
		        //add skills
		        String skillname = prop.getProperty("skillname");
		        String desc = prop.getProperty("desc");
		        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		        driver.findElement(By.xpath("//input[@id='skill_name']")).sendKeys(skillname);
		        driver.findElement(By.xpath("//textarea[@id='skill_description']")).sendKeys(desc);
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		        
		        //take screenshot
		        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        Files.copy(src, new File("C:\\Users\\DHVITTHA\\eclipse-workspace\\Selenium\\Screenshot\\"+" SKILL"+ System.currentTimeMillis() + ".png"));
		        
		      //verify added skill
		        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr/td[@class='tdName tdValue']"));
		        for(WebElement skill : rows)
		        {
		        	Assert.assertEquals(skill.getText(), "Automation");
		        	System.out.println("After adding skill : Automation Testing skill found");
		        	break;
		        		
		        	
		        }
		        
		        
		        //delete skill
		        driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).click();
		        driver.findElement(By.xpath("//input[@value='Delete']")).click();
		        Thread.sleep(3000);
		        
		        
		        //verify deleted or not
		        List<WebElement> rows2 = driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr/td[@class='tdName tdValue']"));
		        for(WebElement skill : rows2)
		        {
		        	if(skill.getText()!="Automation")
		        	{
		        		System.out.println("After adding skill : Automation Testing skill not found");
		        		break;
		        		
		        	}
		        }
		        
		        driver.close();
			}

}