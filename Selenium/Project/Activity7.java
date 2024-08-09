package SeleniumProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {
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
	public void salesLeadTest() {
		
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
		
		WebElement sales = driver.findElement(By.xpath("//a[text()='Sales']"));
		sales.click();
		
		WebElement lead = driver.findElement(By.xpath("//a[text()='Leads']"));
		lead.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	
		
		/*WebElement column = driver.findElement(By.xpath("//table[contains(@Class, 'list view table-responsive')]/tbody/tr[1]/td"));
		column.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());*/
		
	List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@Class, 'list view table-responsive')]/tbody/tr[1]/td"));
		wait.until(ExpectedConditions.visibilityOfAllElements(columns));
		System.out.println("Table first row column size is: "+columns.size());
		for (WebElement column: columns) {
			System.out.println("Columns text is: "+ column);
			System.out.println("Column location is: "+column.getTagName());
			if(column.getText() =="FirefoxDriver: firefox on windows (705197d8-4668-4570-94e9-7f0a29435640)") {
				column.click();
				
			}
			else {
				System.out.println("Column Text is not matched");
			}
		}
	}
	
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
