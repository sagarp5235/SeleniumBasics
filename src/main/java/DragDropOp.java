import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropOp {

	WebDriver driver;
	
	@Before
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demoqa.com/droppable/");
	}
	
	@Test
	public void DragDropTest() throws InterruptedException {
		WebElement dragable = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropable = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//p[text()='Drop here']"));
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		
		//action.clickAndHold(dragable).moveToElement(dropable).release(dragable).build().perform(); //basic method
		
		
		action.dragAndDrop(dragable, dropable).build().perform();
		Thread.sleep(4000);
		WebElement result = driver.findElement(By.xpath("//div/p[text()='Dropped!']"));
		Assert.assertEquals("Operation failed","Dropped!", result.getText());
	}
	
	@After
	public void CloseBrowser() {
		
		driver.quit();
	}
}
