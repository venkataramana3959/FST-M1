package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		driver= new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void loginTest() {
		
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
		String title = driver.getTitle();
		System.out.println("Title is: "+ title);
		String expectedTitle="SuiteCRM";
		Assert.assertEquals(title, expectedTitle);
		driver.quit();
		
	}

}
