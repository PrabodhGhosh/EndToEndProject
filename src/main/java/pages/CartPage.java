package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	public WebDriver driver;

	@FindBy(id = "cgv")
	private WebElement termsOfService;

	@FindBy(xpath = "//div[@id='HOOK_PAYMENT']/div/div/p")
	private WebElement wirePayment;

	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrder;

	@FindBy(xpath = "//p[@class='cart_navigation exclusive']/a")
	private WebElement backToOrder;

	@FindBy(xpath = "//span[contains(text(),'Home')]")
	private WebElement home;

	@FindBy(xpath = "(//span[contains(text(),'Proceed to checkout')])[2]")
	private WebElement proceedToCheckOut;

	@FindBy(xpath = "(//a[contains(text(),'Faded Short Sleeve T-shirts')])[2]")
	private WebElement productToCheckout;
	
	@FindBy(xpath = "//span[@id='total_price']")
	private WebElement totalPrice;

	

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Check terms of service

	public void checkTermsOfService() {
		termsOfService.click();
	}

	// Choose wire payment

	public void chooseWirePayment() {
		wirePayment.click();
	}

	// Confirm order

	public void confirmOrder() {
		confirmOrder.click();
	}

	// Back to order

	public void backToOrder() {
		backToOrder.click();
	}

	// Back to home

	public void backToHome() {
		home.click();
	}

	// Click proceed to checkout

	public void proceedToCheckOut() {
		proceedToCheckOut.click();
	}

	// Get Product name

	public String getProductName() {
		return productToCheckout.getText();
	}
	
	// Get Total Price

		public String getTotalPrice() {
			return totalPrice.getText();
		}

}
