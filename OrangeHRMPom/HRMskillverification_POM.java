package OrangeHRMPom;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HRMskillverification_POM 
{
WebDriver driver = null;
	
	//create constructor
	public HRMskillverification_POM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='table hover']/tbody/tr/td[@class='tdName tdValue']")
	List<WebElement> rows;
	
	public void add_verify()
	{
        for(WebElement skill : rows)
        {
        	Assert.assertEquals(skill.getText(), "Automation Testing");
        	System.out.println("After adding skill : Automation Testing skill found");
        	break;
        }
	}
	
	public void del_verify()
	{
		for(WebElement skill : rows)
        {
        	if(skill.getText()!="Automation Testing")
        	{
        		System.out.println("After deleting skill : Automation Testing skill not found");
        		break;
        		
        	}
        }
	}
}
