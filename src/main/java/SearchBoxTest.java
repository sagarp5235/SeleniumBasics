import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SearchBoxTest{
	WebDriver driver;
	Actions action;

	String resultSearch ="levis sweatshirts for men";
	
	@Before
	public void launch() {
		driver = new ChromeDriver();
		action = new Actions(driver);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void testLogic() throws InterruptedException {
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("levis");
		//driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		Thread.sleep(8000);
		List <WebElement> searchList = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']"));
		for(int index = 0; index<searchList.size(); index++) {
		
			if(searchList.get(index).getText().equalsIgnoreCase(resultSearch)) {
				searchList.get(index).click();
			}
			
		}
	}
	
	@After
	public void close() {
		
		driver.quit();
	}
	
}

