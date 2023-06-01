package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	GeneralUtilities gu = new GeneralUtilities();

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	WebElement SignInButton;

	@FindBy(name = "username")
	WebElement userNameField;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(xpath = "//div//div//h5[contains(text(),'Alert')]//parent::div")
	WebElement errorMessage;

	public String verifySignInButtonText() {
		return gu.getElementText(SignInButton);
	}

	public void enterUserName(String uname) {
		// userNameField.sendKeys(uname);
		gu.enterAValue(userNameField, uname);

	}

	public void enterPassword(String pwd) {
		// passwordField.sendKeys(pwd);
		gu.enterAValue(passwordField, pwd);

	}

	public void clickSigninButton() {
		// SignInButton.click();
		gu.clickAnElement(SignInButton);
	}

	public boolean verifyDisplayOfErrorMessage() {
//		boolean display=errorMessage.isDisplayed(); -->instead of this two line of codes utility is used
//		return display;
		return gu.isElementPresent(errorMessage);

	}
	
	public void performLogin(String uname,String pwd) {
		gu.enterAValue(userNameField, uname);
		gu.enterAValue(passwordField, pwd);
		gu.clickAnElement(SignInButton);
	}
}