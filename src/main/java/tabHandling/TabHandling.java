package tabHandling;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabHandling {
	
	WebDriver driver;

	@Before
	public void browserLaunch() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/browser-windows");
		
	}

	@Test
	public void tabHandleOp() throws InterruptedException{
		WebElement tabLaunchBtn = driver.findElement(By.xpath("//button[@id='tabButton' and text()='New Tab']"));
		tabLaunchBtn.click();
		Thread.sleep(4000);
		
		Set<String> windowsHandle = driver.getWindowHandles();
		Iterator<String> itr =windowsHandle.iterator();
		String baseWindow = itr.next();
		String nextWindow = itr.next();
		System.out.println("windows id for base tab is :-->"+baseWindow);
		System.out.println("windows id for next tab is :-->"+nextWindow);

		driver.switchTo().window(nextWindow);
		System.out.println("Title of the next tab is :-->" + driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(baseWindow);
	String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
	}
	
	@After
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
