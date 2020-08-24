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
	HomePage home;
	public static Logger log = LogManager.getLogger(NewsletterSubsTest.class.getName());
	public String testDataPath= (System.getProperty("user.dir")) + "\\testdata\\testdata.properties";

	@Test

	public void verifyEmptyEmail() throws IOException {
		log.info("Newsletter subscription with empty email test started");
		driver = initializeDriver();
		home = new HomePage(driver);
		home.closePopUp();
		home.clickNewsLetterSubmit();
		Assert.assertEquals(home.getNewsLetterError(), Utility.getValue(testDataPath, "NewsLetterError"));
		log.info("Newsletter subscription with empty email test started");
		
	}
	
	
	@Test

	public void verifyInvalidEmail() throws IOException {
		log.info("Newsletter subscription with invalid email test started");
		driver = initializeDriver();
		home = new HomePage(driver);
		home.closePopUp();
		home.enterNewsLetterInput(Utility.getValue(testDataPath, "InvalidEmail"));
		log.info("Invalid email: "+ Utility.getValue(testDataPath, "InvalidEmail"));
		home.clickNewsLetterSubmit();
		Assert.assertEquals(home.getNewsLetterError(), Utility.getValue(testDataPath, "NewsLetterError"));
		log.info("Newsletter subscription with invalid email test completed");
		
	}
	
	@Test

	public void verifyValidEmail() throws IOException {
		log.info("Newsletter subscription with valid email test started");
		String validEmail = new Random().nextInt(1000)+Utility.getValue(testDataPath, "ValidEmail");
		driver = initializeDriver();
		home = new HomePage(driver);
		home.closePopUp();
		home.enterNewsLetterInput(validEmail);
		log.info("Valid email: "+ validEmail);
		home.clickNewsLetterSubmit();
		Assert.assertEquals(home.getNewsLetterError(), Utility.getValue(testDataPath, "NewsLetterSuccess"));
		log.info("Newsletter subscription with valid email test completed");
		
	}
	
	
	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

}
