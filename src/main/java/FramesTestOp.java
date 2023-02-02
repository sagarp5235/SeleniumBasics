import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesTestOp {
	
	WebDriver driver;
	
	@Before
	public void launchBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Frames.html");
	
	}
	
	@Test
	public void frameTest1() throws InterruptedException{
		
		WebElement frameOption = driver.findElement(By.xpath("//a[text()='Single Iframe ']"));
		frameOption.click();
		
		WebElement frameLocator = driver.findElement(By.xpath("//iframe[@name='SingleFrame']"));
		driver.switchTo().frame(frameLocator);
		WebElement frameText = driver.findElement(By.xpath("//input[@type='text']"));
		Thread.sleep(2000);
		frameText.sendKeys("ABC");
		
		driver.switchTo().defaultContent();
		
	}
	
	@After
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
		
	}

}
	
