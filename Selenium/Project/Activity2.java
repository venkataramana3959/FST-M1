package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		driver= new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void imageURlTest() {
		
		WebElement img =driver.findElement(By.xpath("//form[@id='form']/div/img"));
		String imgurl = img.getAttribute("src");
		System.out.println("img url is: "+ imgurl);
		
		String expectedurl = "https://alchemy.hguy.co/crm/themes/default/images/company_logo.png?v=cK7kLsY0ftg72ZVHTYUT_g";
		
		Assert.assertEquals(imgurl, expectedurl);
		driver.quit();
	}

}
