package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.EditPages;
import elementRepository.LoginPage;
import elementRepository.ManagePagesList;

public class EditPageTestcases extends BaseClass {

	LoginPage lp;
	DashboardPage home;
	ManagePagesList managelist;
	EditPages edit;

	@Test(enabled=true)
	@Parameters("browser")
	public void verifyEditFunctionality() {
		//not working in debug mode as well
		lp = new LoginPage(driver);
		lp.performLogin("admin", "admin");
		managelist = new ManagePagesList(driver);
		managelist.clickManageContentTab();
		managelist.clickManagePagesTab();
		managelist.clickEditButton();
		edit = new EditPages(driver);
		edit.enterValueInDescriptionField();
		edit.boldDescriptionText();
		edit.deleteImage();
		edit.selectAnImage();
		edit.clickUpdateButton();
		String actual = edit.verifyUpdateSuccessAlertMessage();
		String expected = " Alert!";
		Assert.assertEquals(actual, expected, Constant.errorMessageForVerifyEditFunctionality);

	}
}
