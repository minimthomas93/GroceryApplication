package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class OrderDetailsPage {
WebDriver driver;

	public OrderDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtility wu=new WaitUtility();
	
	@FindBy(xpath="//h1[contains(text(),'Order Details')]")
	WebElement orderDetailsTitle;
	
	@FindBy(xpath="")
	WebElement orderIdValue;
	
	public String getTitleOfOrderDetailsPage() {
		String text=gu.getElementText(orderDetailsTitle);
		return text;
	}
	
	public String getValueOfOrderId() {
		String value=gu.getElementText(orderIdValue);
		return value;
	}
	
	
}
