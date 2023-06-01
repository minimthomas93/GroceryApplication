package testCases;

import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManagePagesList;

public class ManagePagesListTestcases extends BaseClass {

	LoginPage lp;
	ManagePagesList managelist;

	@Test
	public void verifyPageIsScrollable() {
		lp = new LoginPage(driver);
		lp.performLogin("admin", "admin");
		managelist = new ManagePagesList(driver);
		managelist.clickManageContentTab();
		managelist.clickManagePagesTab();
		managelist.scrollPage();
		//how to asssert?

	}

}
