package elementRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;

public class ManageProductPage {
	WebDriver driver;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	GeneralUtilities gu = new GeneralUtilities();

	@FindBy(xpath = "//li//a//p[contains(text(),'Manage Product')]")
	WebElement manageProductTab;

	@FindBy(xpath = "//div//h1[contains(text(),'List Products')]")
	WebElement listProductPageTitle;

	@FindBy(xpath = "//div//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/add']")
	WebElement newButton;

	@FindBys({ @FindBy(xpath = "//tbody//tr//td[7]"), })
	List<WebElement> statusValues;

	@FindBys({ @FindBy(xpath = "//tbody//tr//td[9]//a[2]"), })
	WebElement deleteButton;

	@FindBy(xpath = "//div//a[@href='javascript:void(0)']")
	WebElement searchButton;

	@FindBy(id = "cat_id")
	WebElement categoryDropdown;

	@FindBy(id = "sb")
	WebElement subcategoryDropdown;

	@FindBy(name = "Search")
	WebElement searchButtonInSearchPage;

	@FindBy(xpath = "//td//span//center[contains(text(),'RESULT NOT FOUND')]")
	WebElement noResultMessage;

	@FindBy(name = "Reset")
	WebElement resetButtonInSearchList;
	
	@FindBy(xpath="//div//h4[contains(text(),'Search List Products')]")
	WebElement searchListProductsTitle;
	
	public void clickManageProductTab() {
		gu.clickAnElement(manageProductTab);
	}

	public String verifyTitleOfListProductsPage() {
		return gu.getElementText(listProductPageTitle);
	}

	public void clickNewButton() {
		gu.clickAnElement(newButton);
	}

	public boolean VerifyDeleteAction() {

		boolean value = false;

		for (int i = 0; i < statusValues.size(); i++) {
			if (statusValues.get(i).getText().equals("Inactive")) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
//				gu.waitForAnElement(deleteButton);
				// deleteButton.click();
				gu.clickAnElement(deleteButton);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(3000));
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
//				gu.dismissAnAlert();
				value = true;
				break;
			}
		}
		return value;
	}

//	public String selectValuFromXXXDropDown() {
//		String text=gu.selectValueFromDropdown(deleteButton, "Test");
//		return text;//actual result
//	}
//	
//	public String selecteValueFromYYYYDropdown() {
//		String text =gu.selectValueFromDropdown(newButton, "Hello");
//		return text;
//	}

	public void clickSearchButton() {
		gu.clickAnElement(searchButton);
	}

	public void selectCategory() {
		gu.selectValueFromDropdown(categoryDropdown, "Fruits");
	}

	public void selectSubCategory() {
		gu.selectValueFromDropdown(subcategoryDropdown, "apple");
	}

	public void clickSearchButtonInSearchPage() {
		gu.clickAnElement(searchButtonInSearchPage);
	}

	public String verifyNoResultMessageText() {
		return gu.getElementText(noResultMessage);
	}
	
	public boolean verifySearchListProductsTitle() {
		return gu.isElementPresent(searchListProductsTitle);
	}

	public void clickResetButtonInSearchListProductsPage() {
		gu.clickAnElement(resetButtonInSearchList);
	}
}
