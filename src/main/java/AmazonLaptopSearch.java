import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonLaptopSearch {
	
	WebDriver driver;
	
	@Before
	public void launchBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void searchLaptop() throws InterruptedException {
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@type='text' and @id='twotabsearchtextbox']"));
		searchBox.sendKeys("laptop");
		Thread.sleep(4000);
		
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button' and @type='submit']"));
		searchButton.click();
		Thread.sleep(5000);
		
		WebElement brandExpand = driver.findElement(By.xpath("//div[@id='brandsRefinements']//span[@class='a-expander-prompt' and text()='See more']"));
		brandExpand.click();
		
		WebElement brandSelect = driver.findElement(By.xpath("//div[@id='brandsRefinements']//span[text()='Apple']"));
		brandSelect.click();
		System.out.println(100+100 +"abc @123");
		System.out.println("abc"+100+100);
		
	}
	
	@After
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		
	}

}
