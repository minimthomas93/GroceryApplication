package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManagePagesList {

WebDriver driver;
	
	public ManagePagesList(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtility wu=new WaitUtility();
	
	@FindBy(xpath="//section//div//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/add']")
	WebElement newButton;
	
	@FindBy(xpath="//li//a//p[contains(text(),'Manage Content')]")
	WebElement manageContentTab;
	
	@FindBy(xpath="//li//a//p[contains(text(),'Manage Pages')]")
	WebElement managePagesTab;

	
	@FindBy(xpath="//tbody//tr[1]//td//a[@role='button']//i[@class='fas fa-edit']")
	WebElement editButton;
	
	@FindBy(xpath="//li//a[@href='http://groceryapp.uniqassosiates.com/admin/list-page?page_ad=1']")
	WebElement pageOneElement;
	
	public void clickNewButton() {
		gu.clickAnElement(newButton);
	}

	
	public void clickEditButton() {
		gu.clickAnElement(editButton);
	}
	public void clickManageContentTab() {
		gu.clickAnElement(manageContentTab);
	}
	public void clickManagePagesTab() {
		gu.clickAnElement(managePagesTab);
	}
	
	public void scrollPage() {
		wu.waitForElementClickable(pageOneElement, driver);
		gu.scrollPage(driver, pageOneElement);
		wu.waitForElementClickable(pageOneElement, driver);
	}
	
}
