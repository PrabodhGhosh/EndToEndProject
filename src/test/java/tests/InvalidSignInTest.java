package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.SignInPage;
import resources.Utility;

public class InvalidSignInTest extends Base {
	public WebDriver driver;
	HomePage home;
	SignInPage signInPage;
	public static Logger log = LogManager.getLogger(InvalidSignInTest.class.getName());
	public String loginDataPath= (System.getProperty("user.dir")) + "\\testdata\\logindata.properties";
	public String testDataPath= (System.getProperty("user.dir")) + "\\testdata\\testdata.properties";

	@Test(dataProvider = "getInvalidLoginData")

	public void testLogin(String user, String pass) throws IOException {
		log.info("Invalid sign in test started");
		driver = initializeDriver();
		home = new HomePage(driver);
		signInPage = new SignInPage(driver);
		home.clickSignIn();
		home.verifyHeader();
		home.verifyFooter();
		signInPage.enterUser(user);
		log.info("User id: "+user);
		signInPage.enterPassword(pass);
		log.info("Password: "+pass);
		signInPage.clickSignIn();
		Assert.assertEquals(signInPage.getErrorText(),Utility.getValue(testDataPath, "ErrorMessage"));
		log.info("Invalid sign in test completed");

	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

	@DataProvider

	public Object[][] getInvalidLoginData() {
		Object[][] data = new Object[2][2];
		data[0][0] = Utility.getValue(loginDataPath, "User1");
		data[0][1] = Utility.getValue(loginDataPath, "Pass1");
		data[1][0] = Utility.getValue(loginDataPath, "User2");
		data[1][1] = Utility.getValue(loginDataPath, "Pass2");

		return data;
	}

}
