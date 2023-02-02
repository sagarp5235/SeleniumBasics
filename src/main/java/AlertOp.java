import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertOp {
	
	WebDriver driver;
	 String msg="ABC";
	@Before
	public void setupBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.automationtesting.in/Alerts.html");
	}
	
	@Test
	public void AlertTest1() throws InterruptedException {
		Assert.assertEquals("Test failed Wrong URL","https://demo.automationtesting.in/Alerts.html", driver.getCurrentUrl());
		WebElement alertOption = driver.findElement(By.xpath("//a[(text()='Alert with OK ')]"));
		alertOption.click();
		Assert.assertEquals("Test Failed Option not found","Alert with OK", alertOption.getText());
		Thread.sleep(3000);
		
		WebElement alertBtn = driver.findElement(By.xpath("//button[contains(text(),'click the button to display an  alert box:')]"));
		Assert.assertEquals("Test Failed button not found","click the button to display an alert box:", alertBtn.getText());
		alertBtn.click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Test Failed Alert text not matching ->","I am an alert box!", alert.getText() );
		Thread.sleep(4000);

		alert.accept();
		
	}
	
	@Test
	public void AlertTest2() throws InterruptedException {
		
		WebElement alertOption = driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']"));
		Assert.assertEquals("Test Failed option not available","Alert with OK & Cancel",alertOption.getText());
		alertOption.click();
		
		WebElement alertBtn = driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box ')]"));
		alertBtn.click();

		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Test Failed no matching alert Message","Press a Button !",alert.getText());
		Thread.sleep(4000);
		alert.dismiss();
		WebElement resultText = driver.findElement(By.xpath("//p[text()='You Pressed Cancel']"));
		Assert.assertEquals("Test failed wrong reaction","You Pressed Cancel", resultText.getText());
	}
	
	@Test
	public void AlertTest3() throws InterruptedException {
		
		WebElement alertOption = driver.findElement(By.xpath("//a[text()='Alert with Textbox ']"));
		Assert.assertEquals("Test Failed location of element not matching","a", alertOption.getTagName());
		alertOption.click();
		
		 WebElement alertBtn = driver.findElement(By.xpath("//button[text()='click the button to demonstrate the prompt box ']"));
		 alertBtn.click();
		 Alert alert = driver.switchTo().alert();
		 Thread.sleep(4000);
		 alert.sendKeys(msg);
		 Thread.sleep(3000);
		 alert.accept();
		 WebElement resultText = driver.findElement(By.xpath("//p[@id='demo1']"));
		// System.out.println(resultText.getText());
		 Assert.assertEquals("Test failed result text not matching->","Hello " +msg+ " How are you today", resultText.getText());
	}
	
	@After
	public void closeBrowser() throws InterruptedException {
		
		Thread.sleep(4000);
		driver.quit();
		
	}

}
