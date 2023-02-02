
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Practice {
	
	WebDriver driver;
	
	@Before
	public void launch() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		
	}
	
	@Test
	public void check() throws InterruptedException  {
	WebElement searchBox =	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/form[1]"));
		searchBox.sendKeys("Samsung");
		Thread.sleep(3000);
		WebElement searchButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/span[1]/input[1]"));
		searchButton.click();
		Assert.assertEquals("\"samsung\"", driver.getTitle());
		
	}
	@After
	public void closeBrowser() {
		driver.quit();
	}
		

}
