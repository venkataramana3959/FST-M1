package SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		driver= new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void titleTest() {
		
		String title= driver.getTitle();
		System.out.println("Actual page title is: "+ title);
		String expectedTitle ="SuiteCRMS";
		Assert.assertEquals(title, expectedTitle);
		driver.quit();
		
		
	}

}
