package readConfigFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadConfigProperty {

	WebDriver driver;
	public Properties prop;
	
	
	@Before
	public void setUpBrowser() {
		
		driver = new ChromeDriver();
		prop = new Properties();
		try {
			FileInputStream inputStream  = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			prop.load(inputStream);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("issue loading config file");
			e.printStackTrace();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(prop.getProperty("maximize").equalsIgnoreCase("YES")) {
			driver.manage().window().maximize();
		}
		
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void readConfig() {
		
		WebElement searchBoxEle = driver.findElement(By.xpath("//input[@type='text' and @id='twotabsearchtextbox']"));
		searchBoxEle.sendKeys(prop.getProperty("searchKeyword"));
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button' and @type='submit']"));
		searchButton.click();
		
		Assert.assertEquals("Operation failed", prop.getProperty("searchResult"), driver.getTitle());
	}
	
	
	@After
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		
	}
	
}
