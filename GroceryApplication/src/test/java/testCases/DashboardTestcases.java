package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AddProductPage;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;

public class DashboardTestcases extends BaseClass {

	LoginPage lp;
	DashboardPage dp;
	
	
  @Test(groups={"Sanity"})
  public void clickLogoutButton() {
		lp = new LoginPage(driver);
		lp.performLogin("admin", "admin");
		dp = new DashboardPage(driver);
		dp.clickAdminButton();
		dp.clickLogoutButton();
		String actual=lp.verifySignInButtonText();
		String expected="Sign In";
		Assert.assertEquals(actual, expected, Constant.errorMessageForClickLogoutButton);
  }
  
 
  
}
