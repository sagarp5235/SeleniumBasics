import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenShotGrabOp {

	
	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void setupBrowser() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");
	}
	
	@Test
	public void grabScreenshot() {
		WebElement searchBoxEle = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBoxEle.sendKeys("samsung");
		WebElement searchBtnEle = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchBtnEle.click();
		wait.until(ExpectedConditions.titleContains("samsung"));
		
		getScreenShot(driver, "samsungsearch");
	}
	
	@After
	public void closeBrowser() {
		
		driver.quit();
		
	}
	
	public static void getScreenShot(WebDriver driver, String fileName) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		// LocalDateTime time = LocalDateTime.now();
	try {
		
		FileUtils.copyFile(file, new File( System.getProperty("user.dir") + "/src/main/java/jUnitPractice/screenshots/" + fileName + System.currentTimeMillis()+".jpg"));
				
	} catch (IOException e) {
		
		e.printStackTrace();}

	}
}
