package elementRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class AddPage {
WebDriver driver;
	
	public AddPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtility wu=new WaitUtility();
	

	@FindBy(id="title")
	WebElement titleTextbox;
	
	@FindBy(xpath="//div[@class='note-editable card-block']")
	WebElement descriptionTextbox;
	
	@FindBy(xpath="//div[@class='note-editable card-block']//p")
	WebElement textInDescriptionField;
	
	@FindBy(name="page")
	WebElement pageTextbox;	
	
	@FindBy(id="main_img")
	WebElement chooseFileButton;
	
	@FindBy(xpath="//div//button[contains(text(),'Save')]")
	WebElement saveButton;
	
	@FindBy(xpath="//div//h5[contains(text(),' Alert!')]")
	WebElement addSuccessAlertMessage; 
	
	public void enterValueInTitleField() {
		gu.enterAValue(titleTextbox, "Flower");
	}
	
	public void enterValueInDescriptionField() {
		gu.enterAValue(descriptionTextbox, "Description for Flower Page");
	}
	
	public void enterValueInPageField() {
		gu.enterAValue(pageTextbox, "Flower");
	}
	
	public void selectAnImage() {
		gu.enterAValue(chooseFileButton, System.getProperty("user.dir")+"\\src\\test\\resources\\Flower image.jpg");
		wu.waitForElementClickable(saveButton, driver);
	}
	
	public void clickSaveButton() {
		gu.clickAnElement(saveButton);
	}
	
	public String verifyAddSuccessAlertMessage() {
		String text=gu.getElementText(addSuccessAlertMessage);
		return text;
	}
	
	public void scrollPage() {
		wu.waitForElementClickable(saveButton, driver);
		gu.scrollPage(driver, saveButton);
		wu.waitForElementClickable(saveButton, driver);
}
}
