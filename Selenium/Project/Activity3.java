package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		driver= new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void footerTest() {
		
		String footerText =driver.findElement(By.id("admin_options")).getText();
		
		System.out.println("Footer First Text is: "+footerText);
		String expectedText ="© Supercharged by SuiteCRM";
		Assert.assertEquals(footerText, expectedText);
		driver.quit();
	}

}
