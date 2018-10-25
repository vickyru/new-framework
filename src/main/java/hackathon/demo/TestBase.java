package hackathon.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import list.AppEvent;

public class TestBase{
	
	public WebDriver driver;
	public AppEvent appListener ;
	EventFiringWebDriver eventFiringDriver;
	
	@BeforeTest
	private void beforeTest() {
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe" );
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://dwin07s1.dev.affinnova.com/platformservices/");
		appListener = new AppEvent();
		
		// Listeners invocations
		

	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();

	}
	
	@AfterTest
	private void afterTest() {
		
	}
}
