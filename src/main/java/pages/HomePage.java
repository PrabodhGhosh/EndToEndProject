package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(xpath = "//button[contains(text(),'NO THANKS')]")
	private WebElement closePopUp;

	@FindBy(className = "login")
	private WebElement signIn;

	@FindBy(xpath = "//div[@class='row']/nav")
	private WebElement header;

	@FindBy(xpath = "//div[@class='footer-container']")
	private WebElement footer;

	@FindBy(xpath = "//button[@name='submitNewsletter']")
	private WebElement submitNewsLetter;

	@FindBy(xpath = "//div[@id='columns']/p")
	private WebElement newsLetterError;

	@FindBy(id = "newsletter-input")
	private WebElement newsLetterInput;

	@FindBy(xpath = "//a[@title='Women']")
	private WebElement women;

	@FindBy(xpath = "//a[@title='Women']/../ul/li[2]/ul/li[3]/a")
	private WebElement summerDress;

	@FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
	private WebElement productToCheckout;

	@FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]/../../div[2]/a")
	private WebElement addToCart;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOut;
	
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Close the pop up

	public void closePopUp() {
		if (!driver.findElements(By.xpath("//button[contains(text(),'NO THANKS')]")).isEmpty()) {
			closePopUp.click();
		}
	}

	// Click sign in

	public void clickSignIn() {
		signIn.click();
	}

	// Verify presence of header in homepage

	public boolean verifyHeader() {
		return header.isDisplayed();
	}

	// Verify presence of footer in homepage

	public boolean verifyFooter() {
		return footer.isDisplayed();
	}

	// Enter news letter input

	public void enterNewsLetterInput(String option) {
		newsLetterInput.sendKeys(option);
		
	}

	// Click news letter submit arrow

	public void clickNewsLetterSubmit() {
		submitNewsLetter.click();
	}

	// Get news letter error message

	public String getNewsLetterError() {
		return newsLetterError.getText();
	}

	// Click on Women Summer Dress

	public void clickWomenSummerDress() {
		Actions action = new Actions(driver);
		action.moveToElement(women).moveToElement(summerDress).click().perform();
	}

	// Add product to cart

	public void addProductToCart() {
		Actions action = new Actions(driver);
		action.moveToElement(productToCheckout).moveToElement(addToCart).click().perform();
	}
	
	// Click proceed to checkout 

		public void proceedToCheckOut() {
			proceedToCheckOut.click();
		}

}
