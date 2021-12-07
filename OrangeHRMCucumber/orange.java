package Cucumber;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class orange {

	public WebDriver driver;
	@Given("^Browser should open$")
	public void Browser_should_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@When("^We should be in Login Page$")
	public void We_should_be_in_Login_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("You are in the login Page");
		Thread.sleep(1000);
	}

	@When("^We enter Username and Password$")
	public void We_enter_Username_and_Password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement user=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		user.click();
		user.sendKeys("Admin");
		System.out.println("Username is entered");
		Thread.sleep(1000);
		WebElement pass= driver.findElement(By.xpath("//input[@id='txtPassword']"));
		pass.click();
		pass.sendKeys("admin123");
		
		Thread.sleep(2000);
	}

	@Then("^User click login button$")
	public void User_click_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	   System.out.println("User has clicked Login button");
	}

	@Then("^We should be in User's Admin$")
	public void We_should_be_in_User_s_Admin() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		System.out.println("User is in his/her Admin page");
	    
	}
	@Then("^We should be in User's Qualification$")
	public void We_should_be_in_User_s_Qualification(){
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.xpath("//body[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[4]")).click();
		System.out.println("User is in his/her Qualification");
	}
	@Then("^Go to skill$")
	public void Go_to_skill(){
	    // Write code here that turns the phrase above into concrete actions
	 driver.findElement(By.xpath("//a[@id='menu_admin_viewSkills']")).click();;
		System.out.println("Go to skill");
	}
	@Then("^Click on add button$")
	public void Click_on_add_buttonl(){
	    // Write code here that turns the phrase above into concrete action
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		System.out.println("Click on add button");
	}
	@When("^Add skill name$")
	public void Add_skill_name() throws InterruptedException{
	    // Write code here that turns the phrase above into concrete action
        WebElement name=driver.findElement(By.xpath("//input[@id='skill_name']"));
		name.click();
		name.sendKeys("Automation Testing");
		System.out.println("Username is Skill Name");
		Thread.sleep(1000);
		
	    WebElement desp=driver.findElement(By.xpath("//textarea[@id='skill_description']"));
	    desp.click();
	    desp.sendKeys("Test");
	    System.out.println("Programming language");
		Thread.sleep(1000);
	}
	@Then("^Click on save button$")
	public void Click_on_save_buttonl(){
	    // Write code here that turns the phrase above into concrete action
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		System.out.println("Click on save button");
	}
	@Then("^Take Screenshot$")
	public void Take_Screenshot() throws IOException{
	    // Write code here that turns the phrase above into concrete action
		 File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     Files.copy(src, new File("C:\\Users\\DHVITTHA\\eclipse-workspace\\Selenium\\Screenshot\\AddSkill"+".png"));
		System.out.println("Take Screenshot");
	}
	@Then("^Delete Skill$")
	public void Delete_Skill() throws InterruptedException{
	    // Write code here that turns the phrase above into concrete action
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
	        System.out.println("Delete skill");
	}
	@Then("^Close browser$")
	public void Close_browser(){
	    // Write code here that turns the phrase above into concrete action
		 driver.close();
		System.out.println("Close Browser");
	}
}
