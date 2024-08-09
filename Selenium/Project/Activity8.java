package SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
WebDriver driver;
	
	WebDriverWait wait;
	
	
	@BeforeMethod
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.get("http://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
	@Test
	public void Test() {}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
