import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameNestedOp {

	WebDriver driver;
	
	@Before
	public void launchBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.automationtesting.in/Frames.html");
		
	}
	
	@Test
	public void testNestedframes() throws InterruptedException {
		
		WebElement frameSelect = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
		frameSelect.click();
		Assert.assertEquals("Test failed ","Iframe with in an Iframe",frameSelect.getText());

		WebElement frameSelectorParent = driver.findElement(By.xpath("//div[@id='Multiple']//iframe"));
		driver.switchTo().frame(frameSelectorParent);
		
		Thread.sleep(3000);
		
		WebElement frameSelectorChild= driver.findElement(By.xpath("//div[@class='iframe-container']//iframe"));
		driver.switchTo().frame(frameSelectorChild);
		
		WebElement frameText = driver.findElement(By.xpath("//input[@type='text']"));
		frameText.sendKeys("ABC");
		
		driver.switchTo().defaultContent();
	}
	
	@After
	public void closeBrowser() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
	}
}
