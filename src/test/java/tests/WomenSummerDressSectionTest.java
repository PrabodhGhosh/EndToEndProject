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
import pages.WomenSummerDressPage;
import resources.Utility;

public class WomenSummerDressSectionTest extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomepageTest.class.getName());
	HomePage home;
	WomenSummerDressPage womenSummerDress;
	public String testDataPath= (System.getProperty("user.dir")) + "\\testdata\\testdata.properties";

	@Test

	public void verifyProductCount() throws IOException {
		driver = initializeDriver();
		home = new HomePage(driver);
		womenSummerDress = new WomenSummerDressPage(driver);
		home.closePopUp();
		home.clickWomenSummerDress();
		Assert.assertEquals(womenSummerDress.getProductNumber(), Integer.parseInt(Utility.getValue(testDataPath, "ProductCount")));
	}
	
	
	
	/*  Scenario 3.a & 3.b
	 * Filter and Sorting both are not working, so they cannot be automated.
	 * The loading indicator keeps on rotating without filtering the actual result.
	 * 
	 * However, just to give an idea how to automate them,  I have listed down the steps below - 
	 * 
	 * For 3.a
	 * 
	 * 1. Go to Home Page > Women > Summer Dress
	 * 2. Click on any filter.
	 * 3. Verify the number of products filtered are equal to expected number of products, when done manually.
	 * 
	 * For 3.b
	 * 
	 * 1. Go to Home Page > Women > Summer Dress
	 * 2. Sort by Price: Lowest First
	 * 3. Store all the product prices in an array.
	 * 4. Verify if the array is sorted in ascending order or not and assert the same.
	 * 5. Sort by Product Name: A to Z
	 * 6. Store all the product prices in an array.
	 * 7. Verify if the array is sorted in ascending order or not and assert the same.	 * 
	 * */
	
	
	
	
	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
	
	}