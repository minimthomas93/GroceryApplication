package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageExpensePage {
	WebDriver driver;
	
	public ManageExpensePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtility wu=new WaitUtility();
	
	@FindBy(xpath="//a[@class='nav-link']//i//following-sibling::p[contains(text(),'Manage Expense')]")
	WebElement manageExpenseTab;
	
	@FindBy(xpath="//li[@class='nav-item']//a//p[contains(text(),'Manage Expense')]")
	WebElement manageExpenseSubmenu;
	
	@FindBy(xpath="//div//h1[contains(text(),'List Expense')]")
	WebElement listExpenseTitle;
	
	@FindBy(xpath="//tbody//tr[1]//a[@title='Show Details']//i")
	WebElement viewMoreButton;
	
	@FindBy(xpath="//tr[@class='detail-row open']//div[@class='profile-info-name']//b[contains(text(),'Order Id :')]//parent::div//span//a")
	WebElement orderIdLink;
	
	public void clickOnManageExpenseTab() {
		gu.clickAnElement(manageExpenseTab);
	}
	
	public void clickOnManageExpenseSubMenu() {
		gu.clickAnElement(manageExpenseSubmenu);
	}
	
	public void clickOnViewMoreLink() {
		gu.clickAnElement(viewMoreButton);
	}
	
	public String getOrderIdValue() {
		String value=gu.getElementText(orderIdLink);
		return value;
	}
	
	public void clickOnOrderId() {
		gu.clickAnElement(orderIdLink);
	}
}
