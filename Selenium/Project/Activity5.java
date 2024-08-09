package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver= new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void toolbarColorsTest() {
		
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
		String toolbarColor = driver.findElement(By.id("toolbar")).getCssValue("color");
		System.out.println("Toolbar Colours are: "+ toolbarColor);
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
