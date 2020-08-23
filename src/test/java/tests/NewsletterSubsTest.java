package tests;

import java.io.IOException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import resources.Utility;

public class NewsletterSubsTest extends Base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomepageTest.class.getName());
	HomePage home;
	public String testDataPath= (System.getProperty("user.dir")) + "\\testdata\\testdata.properties";

	@Test

	public void verifyEmptyEmail() throws IOException {
		
		driver = initializeDriver();
		home = new HomePage(driver);
		home.closePopUp();
		home.clickNewsLetterSubmit();
		Assert.assertEquals(home.getNewsLetterError(), Utility.getValue(testDataPath, "NewsLetterError"));
		
	}
	
	
	@Test

	public void verifyInvalidEmail() throws IOException {
		
		driver = initializeDriver();
		home = new HomePage(driver);
		home.closePopUp();
		home.enterNewsLetterInput(Utility.getValue(testDataPath, "InvalidEmail"));
		home.clickNewsLetterSubmit();
		Assert.assertEquals(home.getNewsLetterError(), Utility.getValue(testDataPath, "NewsLetterError"));
		
	}
	
	@Test

	public void verifyValidEmail() throws IOException {
		
		driver = initializeDriver();
		home = new HomePage(driver);
		home.closePopUp();
		home.enterNewsLetterInput(new Random().nextInt(1000)+Utility.getValue(testDataPath, "ValidEmail"));
		home.clickNewsLetterSubmit();
		Assert.assertEquals(home.getNewsLetterError(), Utility.getValue(testDataPath, "NewsLetterSuccess"));
		
	}
	
	
	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

}
