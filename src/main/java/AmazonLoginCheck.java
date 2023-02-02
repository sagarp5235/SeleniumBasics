import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonLoginCheck {

	WebDriver driver;
	
	@Before
	public void launchBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/ref=nav_logo");
	}
	
	@Test
	public void loginTest1() throws InterruptedException {
		
	WebElement  loginClickOp = 	driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
	loginClickOp.click();
	Thread.sleep(4000);
	WebElement loginContinue = driver.findElement(By.xpath("//span[@id='continue']"));
	loginContinue.click();
	Thread.sleep(4000);
	WebElement displayMessage = driver.findElement(By.xpath("//div[contains(text(),'  Enter your email or mobile phone number')]"));
	
	Assert.assertEquals("Test failed", "Enter your email or mobile phone number", displayMessage.getText());
		
	}
	
	@Test
	public void loginTest2() throws InterruptedException {
		
			
			WebElement  loginClickOp = 	driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
			loginClickOp.click();
			Thread.sleep(4000);
			WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
			emailInput.sendKeys("abcd");
			Thread.sleep(2000);
			WebElement loginContinue = driver.findElement(By.xpath("//span[@id='continue']"));
			loginContinue.click();
			Thread.sleep(4000);
			
			WebElement loginIdError = driver.findElement(By.xpath("//span[contains(text(),'We cannot find an account with that email address')]"));
			Assert.assertEquals("Test failed System is not showing error","We cannot find an account with that email address", loginIdError.getText());

			
			
	}
	
	@After
	public void closeBrowser() throws InterruptedException {
		
		Thread.sleep(4000);
		driver.quit();
	}
	
}
