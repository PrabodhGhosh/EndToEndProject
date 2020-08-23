package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import resources.Utility;

public class HomepageTest extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomepageTest.class.getName());
	HomePage home;

	@Test

	public void homePageNavigation() throws IOException {
		driver = initializeDriver();
		home = new HomePage(driver);
		home.closePopUp();
		Assert.assertEquals(driver.getCurrentUrl(), (Utility.getValue((System.getProperty("user.dir")) + "\\resources\\appdata.properties", "URL")));
		Assert.assertEquals(home.verifyHeader(), true);
		Assert.assertEquals(home.verifyFooter(), true);
		log.info("Test completed");

	}
	
	

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

}
