package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.CartPage;
import pages.HomePage;
import pages.SignInPage;
import resources.Utility;

public class CheckoutTest extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(CheckoutTest.class.getName());
	HomePage home;
	SignInPage signInPage;
	CartPage cartPage;
	public String testDataPath= (System.getProperty("user.dir")) + "\\testdata\\testdata.properties";

	@Test

	public void checkOutJourney() throws IOException, InterruptedException {
		log.info("Checkout test started");
		driver = initializeDriver();
		home = new HomePage(driver);
		signInPage = new SignInPage(driver);
		cartPage = new CartPage(driver);
		home.closePopUp();
		home.addProductToCart();
		home.proceedToCheckOut();
		Assert.assertEquals(cartPage.getProductName(), Utility.getValue(testDataPath, "ProductName"));
		log.info("Product name :"+ cartPage.getProductName());
		Assert.assertEquals(cartPage.getTotalPrice(), Utility.getValue(testDataPath, "ProductPrice"));
		log.info("Product price :"+ cartPage.getTotalPrice());
		log.info("Checkout test started");
		cartPage.proceedToCheckOut();
		signInPage.enterUser(Utility.getValue(testDataPath, "User"));
		signInPage.enterPassword(Utility.getValue(testDataPath, "Pass"));
		signInPage.clickSignIn();
		cartPage.proceedToCheckOut();
		cartPage.checkTermsOfService();
		cartPage.proceedToCheckOut();
		cartPage.chooseWirePayment();
		cartPage.confirmOrder();
		cartPage.backToOrder();
		cartPage.backToHome();
		log.info("User back to home page");
		log.info("Checkout test completed");
		
	}
	
	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
	
}
