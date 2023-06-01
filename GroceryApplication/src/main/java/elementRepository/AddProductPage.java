package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AddProductPage {
	
WebDriver driver;
	
	public AddProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	GeneralUtilities gu=new GeneralUtilities();
	
	
	
	@FindBy(id="title")
	WebElement titleField;
	
	public boolean verifyDisplayOfTitleField() {
		return gu.isElementPresent(titleField);
	}

}
