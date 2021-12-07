package OrangeHRMPom;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Files;

public class HRMskill_POM 
{
WebDriver driver = null;
	
	//create constructor
	public HRMskill_POM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[contains(text(),'Admin')]")
	WebElement admin;
	
	@FindBy(xpath="//a[@id='menu_admin_Qualifications']")
	WebElement qual;
	
	@FindBy(xpath="//a[@id='menu_admin_viewSkills']")
	WebElement skill;
	
	@FindBy(xpath="//input[@id='btnAdd']")
	WebElement add;
	
	@FindBy(xpath="//input[@id='skill_name']")
	WebElement name;
	
	@FindBy(xpath="//textarea[@id='skill_description']")
	WebElement description;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement save;
	
	@FindBy(xpath="//tbody/tr[1]/td[1]")
	WebElement box;
	
	@FindBy(xpath="//input[@value='Delete']")
	WebElement delete;
	
	public void navigate() throws InterruptedException
	{
		admin.click();
		Thread.sleep(1000);
		qual.click();
		skill.click();
	}
	
	public void skillAdd() throws IOException, InterruptedException
	{
	
	FileInputStream fis = new FileInputStream("C:\\Users\\DHVITTHA\\eclipse-workspace\\sample\\src\\main\\java\\OrangeHRMPom\\Properties\\credential.Properties");
	Properties prop = new Properties();
	prop.load(fis);
	add.click();
	name.sendKeys(prop.getProperty("Name"));
	description.sendKeys(prop.getProperty("Description"));
	Thread.sleep(2000);
	save.click();
	
	}
	
	public void screenshot() throws IOException 
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src, new File("C:\\Users\\DHVITTHA\\eclipse-workspace\\Selenium\\Screenshot\\"+" SKILL "+ System.currentTimeMillis() + ".png"));
	}
	
	public void skillDel()
	{
		box.click();
		delete.click();
	}
	
}