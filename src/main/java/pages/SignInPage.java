package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	public WebDriver driver;

	@FindBy(id = "email")
	private WebElement userId;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(xpath = "//p[contains(text(),'There is 1 error')]")
	private WebElement errorText;

	@FindBy(id = "SubmitLogin")
	private WebElement SignIn;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Enter user id

	public void enterUser(String option) {
		userId.sendKeys(option);
	}

	// Enter password

	public void enterPassword(String option) {
		password.sendKeys(option);
	}

	// Click sign in

	public void clickSignIn() {
		SignIn.click();

	}

	// Get error text

	public String getErrorText() {
		return errorText.getText();

	}

}
