package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenSummerDressPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//ul[@class='product_list grid row']")
	private WebElement productGrid;
	
	
	
	
	public WomenSummerDressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Get product numbers
	
	public int getProductNumber()
	{
		return driver.findElements(By.xpath("//ul[@class='product_list grid row']/li")).size();
	}

}
