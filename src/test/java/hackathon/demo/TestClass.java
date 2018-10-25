package hackathon.demo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;

import accelerators.ActionEngine;

/**
 * @author prashantt
 *
 */

@Listeners(VideoListener.class)
public class TestClass extends ActionEngine {

	/**
	 * @throws Throwable
	 */
	@Test(priority = 0, description = "Valid login scenerio with authenticate username & password")
	@Video(name = "Login Pass Test")
	public void LoginSuccessTC() throws Throwable {
		enter(By.id("username"), "admin@affinnova.com", "User Name");
		enter(By.id("password"), "Affinnova", "Password");
		click(By.id("submit"), "Submit Button");
		Assert.assertEquals(getTitle(), "Nielsen Studio");
		click(By.linkText("Test Admin User user"), "Admin drop down");
		explicitWait();
		click(By.linkText("Log out"), "Logout");
		click(By.id("sign-out-btn"), "Log Out Button");
		Thread.sleep(1000);
	}

	/**
	 * @throws Throwable
	 */
	@Test(priority = 0, description = "Invalid login scenerio with wrong username & password")
	@Video(name = "Login Fail Test")
	public void LoginFailTC() throws Throwable {
		enter(By.id("username"), "admin@affinnova.com", "User Name");
		enter(By.id("password"), "AADSDSDS", "Password");
		click(By.id("submit"), "Submit Button");
		Assert.assertEquals(getTitle(), "Nielsen Studio");
	}

}
