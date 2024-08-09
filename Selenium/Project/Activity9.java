package SeleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = new FirefoxDriver();
		
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		
		System.out.println("Home page title"+driver.getTitle());
		
		//Assert.assertEquals(driver.getTitle(), "Dashboard ‹ Alchemy Jobs — WordPress");
		
		List<WebElement> jobs=driver.findElements(By.xpath("//ul[@id='adminmenu']/li"));
		System.out.println(jobs.size());
		
		for (WebElement job: jobs) {
			String jobtxt=job.getText();
			System.out.println("Job "+jobtxt);
			if (jobtxt.equals("Job Listings 2")) {
				job.click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a")).click();
		
		driver.findElement(By.id("post-title-0")).sendKeys("Automation Tester");
		Thread.sleep(3000);
		
		 WebElement element = driver.findElement(By.id("_company_video"));

	        
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		driver.findElement(By.id("_application")).clear();
		driver.findElement(By.id("_application")).sendKeys("pavankumarch98@gmail.com");
		driver.findElement(By.id("_company_name")).sendKeys("IBM-2021");
		driver.findElement(By.id("_company_tagline")).sendKeys("PavanKumarChowdary");
		List<WebElement> buttons =driver.findElements(By.xpath("//div[@class='edit-post-header__settings']/button"));
		System.out.println("Total Button "+buttons.size());
		
		for(WebElement button: buttons) {
			
			String buttontxt = button.getText();
			System.out.println("Button txt is "+buttontxt);
			if(buttontxt.equals("Publish…")) {
				button.click();
				break;
			}
		}
		
		
		
	}
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}



//Username: root
//Password: pa$$w0rd


