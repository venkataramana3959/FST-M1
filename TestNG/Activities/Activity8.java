package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity8 {
WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver= new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/login-form");
	}
	
	
	@Test
	@Parameters({"username","password"})
	public void loginTest(String username, String password) {
		
		WebElement name = driver.findElement(By.id("username"));
		WebElement passwd = driver.findElement(By.id("password"));
		
		name.clear();
		passwd.clear();
		
		name.sendKeys(username);
		passwd.sendKeys(password);
		
		driver.findElement(By.xpath("//*[text()='Log in']")).click();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
