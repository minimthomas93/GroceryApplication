package elementRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class EditPages {
WebDriver driver;
	
	public EditPages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtility wu=new WaitUtility();
	
	@FindBy(xpath="//div[@class='note-editable card-block']")
	WebElement descriptionTextbox;
	
	@FindBy(xpath="//div[@class='note-editable card-block']//p")
	WebElement textInDescriptionField;
	
	@FindBy(xpath="//div//button[@aria-label='Bold (CTRL+B)']")
	WebElement bold;
	
	@FindBy(xpath="//p//a[@role='button']")
	WebElement deleteImageButton;
	
	@FindBy(id="main_img")
	WebElement chooseFileButton;
	
	@FindBy(name="update")
	WebElement updateButton;
	
	@FindBy(xpath="//div//h5[contains(text(),' Alert!')]")
	WebElement updateSuccessAlertMessage; 
	
	
	public void enterValueInDescriptionField() {
		gu.enterAValue(descriptionTextbox, "EDITED");
	}
	
	
	public void boldDescriptionText() {
		gu.doubleClickAnElement(driver, textInDescriptionField);
		gu.clickAnElement(bold);
	}
	
	public void deleteImage() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(3000));
		gu.clickAnElement(deleteImageButton);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(3000));
		gu.acceptAnAlert(driver);
	}
	
	public void selectAnImage() {
		gu.enterAValue(chooseFileButton, "C:\\Users\\LENOVO\\Pictures\\freesnippingtool.com_capture_20230503151358.png");
		wu.waitForElementClickable(updateButton, driver);
	}
	public void clickUpdateButton() {
		gu.clickAnElement(updateButton);
	}
	public String verifyUpdateSuccessAlertMessage() {
		String text=gu.getElementText(updateSuccessAlertMessage);
		return text;
		
	}
}
