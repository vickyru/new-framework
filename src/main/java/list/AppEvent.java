package list;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AppEvent{

		 public void highlightElement(WebDriver driver,WebElement element) {  
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("arguments[0].style.border='3px solid red'", element);
		 }

		 public void unhighlightLast(WebDriver driver,WebElement element) { 
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("arguments[0].style.border='0px'", element);
	}
}
