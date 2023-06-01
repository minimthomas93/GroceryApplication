package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManagePagesList;
import elementRepository.ManageProductPage;

public class NavigateBetweenPagesTestcases extends BaseClass{
 
	
	LoginPage lp;
	DashboardPage home;
	ManageProductPage product;
	ManagePagesList managelist;
	
	@Test
	public void navigateBetweenPages() {
		lp=new LoginPage(driver);
		lp.performLogin("admin", "admin");
		product=new ManageProductPage(driver);
		product.clickManageProductTab();
		managelist=new ManagePagesList(driver);
		managelist.clickManageContentTab();
		managelist.clickManagePagesTab();
		driver.navigate().back();
		String text1=product.verifyTitleOfListProductsPage();
		Assert.assertEquals(text1, "List Products",Constant.errorMessageForNavigateBetweenPagesListProducts);
		driver.navigate().back();
		home=new DashboardPage(driver);
		String text2=home.verifyTitleOfManagePagesTile();
		Assert.assertEquals(text2, "Manage Pages",Constant.errorMessageForNavigateBetweenPagesListPages);
		driver.navigate().forward();
		product.verifyTitleOfListProductsPage();
		Assert.assertEquals(text1, "List Products",Constant.errorMessageForNavigateBetweenPagesListProducts);

		
	}
	
	
}
