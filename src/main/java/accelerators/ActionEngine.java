package accelerators;

import org.openqa.selenium.By;

import list.MyListener;

/**
 * @author prashantt
 *
 */
public class ActionEngine extends MyListener {


	public boolean click(By locator, String locatorName) throws Throwable {
		boolean status = false;
		try {
			if (driver != null) {
				appListener.highlightElement(driver, driver.findElement(locator));
				driver.findElement(locator).click();
				status = true;
				appListener.unhighlightLast(driver, driver.findElement(locator));
			}
		} catch (Exception e) {
			status = false;
		}
		return status;
	}
	
	public boolean enter(By locator, String testdata, String locatorName) throws Throwable {

	    boolean status = false;
	    try {
	      appListener.highlightElement(driver, driver.findElement(locator));
	      driver.findElement(locator).click();
	      driver.findElement(locator).clear();
	      driver.findElement(locator).sendKeys(testdata);
	      status = true;
	      appListener.unhighlightLast(driver, driver.findElement(locator));
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
			appListener.unhighlightLast(driver, driver.findElement(locator));
		}

	    return status;
	  }
	
	public String getTitle() throws Throwable {
		String text = null ;
		try {
			By locator = By.tagName("title");
			appListener.highlightElement(driver, driver.findElement(locator));
			text = driver.getTitle();
			appListener.unhighlightLast(driver, driver.findElement(locator));
			return text;
		}

		catch (Exception e) {
		}
		return text;
	}
	

	    
	
	public boolean explicitWait() throws Throwable {
	    boolean status = true;
	    long timevalue = Long.parseLong("2");
	    Thread.sleep(timevalue * 1000);
	    return status;

	  }
	
	
	
}
