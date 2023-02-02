import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameDragDropOp {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://jqueryui.com/droppable/");
		
	}
	
	@Test
	public void frameTest() throws InterruptedException {
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		WebElement dragable = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropable = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.dragAndDrop(dragable, dropable).build().perform();
		WebElement afterDrop = driver.findElement(By.xpath("//div/p[text()='Dropped!']"));
		Assert.assertEquals("Test Failed","Dropped!", afterDrop.getText());
		Thread.sleep(4000);
	}
	
	@After
	public void closeBrowser() {
		
		driver.quit();
	}
}
