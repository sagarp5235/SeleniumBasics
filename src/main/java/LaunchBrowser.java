import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
public class LaunchBrowser {

	public static void main(String [] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\sagar\\eclipse-workspace\\SeleniumBasics/geckodriver.exe");
		
	//	WebDriver driver = new FirefoxDriver();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.in");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
		
	}
}
