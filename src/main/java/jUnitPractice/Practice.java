package jUnitPractice;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
	public void check1() throws InterruptedException  {
	WebElement searchBox =	driver.findElement(By.xpath("//div/input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("levi's");
		Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@id='navbar']/div[@id='nav-flyout-iss-anchor']/div[@id='nav-flyout-searchAjax']/div[2]/div[6]/div[1]")).click();
		
		// Assert.assertEquals("Amazon.in : samsung", driver.getTitle());
		System.out.println(driver.getTitle());
		
	}
	
	@Test
	public void check2() {
		driver.navigate().to("https://www.amazon.in/s?k=samsung&ref=nb_sb_noss");
	
		WebElement resultText = driver.findElement(By.xpath("//div/span[contains(text(), '\"samsung\"')]"));
		Assert.assertEquals("\"samsung\"", resultText.getText());
	}
	
	@Test
	public void check3() {
		
		driver.get("https://www.amazon.in/");
		driver.manage().deleteAllCookies();
		List <WebElement> listlink = driver.findElements(By.tagName("a"));
		System.out.println(listlink.size());
		
		for(int index = 0; index<listlink.size(); index++) {
			System.out.println(listlink.get(index).getText());
		}
		
		
	}
	@After
	public void closeBrowser() {
		driver.quit();
	}
	
	

		

}