package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver= new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void toolbarActivityTest() {
		
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
		
		WebElement toolbar = driver.findElement(By.id("toolbar"));
		
		List<WebElement> options = toolbar.findElements(By.tagName("a"));
		
		for (WebElement option : options)
		{
			
			if(option.getText().equalsIgnoreCase("Activities")) {
				System.out.println("Activity option is there in toolbar: "+ option);
				driver.quit();
				
			}
		}
		
	
		
	}
	
/*	@AfterMethod
	public void teardown() {
		driver.quit();
	}*/

}
