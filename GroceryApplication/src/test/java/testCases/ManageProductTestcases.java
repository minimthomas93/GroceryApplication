package testCases;

import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AddProductPage;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;
import utilities.WaitUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ManageProductTestcases extends BaseClass {

	LoginPage lp;
	ManageProductPage product;
	AddProductPage add;
	WaitUtility wu=new WaitUtility();

	@Test
	public void verifyTheClickOfManageProductTab() {
		lp = new LoginPage(driver);
		lp.performLogin("admin", "admin");
		product = new ManageProductPage(driver);
		product.clickManageProductTab();
		String actual = product.verifyTitleOfListProductsPage();
		String expected = "List Products";
		Assert.assertEquals(actual, expected, Constant.errorMessageForVerifyTheClickOfManageProductTab);

	}

	@Test
	public void verifyDisplayofAddProductPage() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickSigninButton();
		product = new ManageProductPage(driver);
		product.clickManageProductTab();
		product.clickNewButton();
		add = new AddProductPage(driver);
		boolean actual = add.verifyDisplayOfTitleField();
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.errorMessageForVerifyDisplayofAddProductPage );

	}

	@Test
	public void verifyDeletionOfAnInactiveProduct() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickSigninButton();
		product = new ManageProductPage(driver);
		product.clickManageProductTab();
		product.VerifyDeleteAction();
		boolean actual = product.VerifyDeleteAction();
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.errorMessageForVerifyDeletionOfAnInactiveProduct);

	}

	@Test
	public void verifyNoSearchResultsMessage() {
		lp = new LoginPage(driver);
		lp.performLogin("admin", "admin");
		product = new ManageProductPage(driver);
		product.clickManageProductTab();
		product.clickSearchButton();
		product.selectCategory();
		product.selectSubCategory();
		product.clickSearchButtonInSearchPage();
		String actual = product.verifyNoResultMessageText();
		String expected = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actual, expected, Constant.errorMessageForVerifyNoSearchResultsMessage);

	}

	@Test
	public void verifyResetActionInSearchListProductsPage() {
		lp = new LoginPage(driver);
		lp.performLogin("admin", "admin");
		product = new ManageProductPage(driver);
		product.clickManageProductTab();
		product.clickSearchButton();
		product.clickResetButtonInSearchListProductsPage();
		boolean actual = product.verifySearchListProductsTitle();
		boolean expected = false;
		Assert.assertEquals(actual, expected, Constant.errorMessageForVerifyResetActionInSearchListProductsPage);

	}
	@Test
	 public void ListProductIsDisplayedAfterRefreshFromSearchPage() {
		  lp = new LoginPage(driver);
		  lp.performLogin("admin", "admin");
		  product = new ManageProductPage(driver);
		  product.clickManageProductTab();
		  product.clickSearchButton();
		  wu.waitForPage(driver);
		  driver.navigate().refresh();
		  String text=product.verifyTitleOfListProductsPage();
		  Assert.assertEquals(text, "List Products",Constant.errorMessageForListProductIsDisplayedAfterRefreshFromSearchPage);		  
	  }

}
