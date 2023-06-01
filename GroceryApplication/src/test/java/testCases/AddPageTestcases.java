package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AddPage;
import elementRepository.DashboardPage;
import elementRepository.EditPages;
import elementRepository.LoginPage;
import elementRepository.ManagePagesList;

public class AddPageTestcases extends BaseClass {
	
	LoginPage lp;
	ManagePagesList managelist;
	AddPage add;
	
	@Test(enabled=true)
	@Parameters("browser")
	public void verifyAddPageFunctionality() {
		//working in debug mode only
		lp = new LoginPage(driver);
		lp.performLogin("admin", "admin");
		managelist = new ManagePagesList(driver);
		managelist.clickManageContentTab();
		managelist.clickManagePagesTab();
		managelist.clickNewButton();
		add=new AddPage(driver);
		add.enterValueInTitleField();
		add.enterValueInDescriptionField();
		add.enterValueInPageField();
		add.selectAnImage();
		add.scrollPage();
		add.clickSaveButton();
		driver.navigate().back();
		String actual=add.verifyAddSuccessAlertMessage();
		String expected = " Alert!";
		Assert.assertEquals(actual, expected,Constant.errorMessageForVerifyAddPageFunctionality);
		
		
		
		
	}
	
	
	
	
}
