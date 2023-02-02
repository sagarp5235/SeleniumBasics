import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownOp {
	
	WebDriver driver;
	
	String firstName = "ABC";
	String lastName = "XYZ";
	String email = "abcd@xyz.com";
	String password = "12345";

	
	@Before
	public void setupBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
	}
	
	@Test
	public void operations() throws InterruptedException {
		WebElement signUpBtn = driver.findElement(By.xpath("//div/a[@role='button'  and text()='Create New Account']"));
		signUpBtn.click();
		
		
		driver.findElement(By.xpath("//div/input[@name='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@type='text' and @name='reg_email__']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='text' and @name='reg_email_confirmation__']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='password' and @name='reg_passwd__']")).sendKeys(password);
		Thread.sleep(2000);
		

		
		WebElement birthDay = driver.findElement(By.id("day"));
		WebElement birthMonth = driver.findElement(By.id("month"));
		WebElement birthYear = driver.findElement(By.id("year"));
		
		Select selectDay = new Select(birthDay);
		selectDay.selectByValue("27");
		Thread.sleep(3000);
		
		Select selectMonth = new Select(birthMonth);
		selectMonth.selectByVisibleText("Apr");
		Thread.sleep(3000);
		
		Select selectYear = new Select(birthYear);
		selectYear.selectByValue("1993");
		Thread.sleep(3000);
		
	WebElement radioSelect = 	driver.findElement(By.xpath("//label[text()='Male']"));
		radioSelect.click();
		
		Assert.assertEquals("Test failed","Male", radioSelect.getText());
		
		
	}
	

	@After
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
		
	}

}
