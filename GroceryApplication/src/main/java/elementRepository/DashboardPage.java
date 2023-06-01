package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	GeneralUtilities gu=new GeneralUtilities();
	
	@FindBy(xpath="//a//p[contains(text(),'Dashboard')]")
	WebElement dashboardElement;
	
	@FindBy(xpath="//li//a[@href='#']//parent::li[@class='nav-item dropdown']")
	WebElement adminButton; 
	
	@FindBy(xpath="//div[@class='dropdown-menu dropdown-menu-lg dropdown-menu-right text_black show']//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logoutButton;
	 
	@FindBy(xpath="//div//h3//following-sibling::p[contains(text(),'Manage Pages')]")
	WebElement ManagePagesTileName;
	
	public String verifyTextOfDashboardElement() {
		return gu.getElementText(dashboardElement);
	}
	public void clickAdminButton() {
		gu.clickAnElement(adminButton);
	}
	
	public void clickLogoutButton()
	{
	gu.clickAnElement(logoutButton);	
	}

	public String verifyTitleOfManagePagesTile() {
		String text=gu.getElementText(ManagePagesTileName);
		return text;
	}
}
