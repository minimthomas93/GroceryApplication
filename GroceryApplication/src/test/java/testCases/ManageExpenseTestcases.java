package testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageExpensePage;
import elementRepository.OrderDetailsPage;

public class ManageExpenseTestcases extends BaseClass {

	LoginPage lp;
	ManageExpensePage expense;
	OrderDetailsPage orderDetails;
	
	@Test
	@Parameters("browser")
	public void verifyDisplayOfOrderDetailsPage() {
		
		lp=new LoginPage(driver);
		lp.performLogin("admin", "admin");
		expense=new ManageExpensePage(driver);
		expense.clickOnManageExpenseTab();
		expense.clickOnManageExpenseSubMenu();
		expense.clickOnViewMoreLink();
		String value1=expense.getOrderIdValue();
		expense.clickOnOrderId();
		Set<String>windowids1=driver.getWindowHandles();
		List<String>windowids2=new ArrayList<String>(windowids1);
		String childid=windowids2.get(1);
		driver.switchTo().window(childid);
		orderDetails=new OrderDetailsPage(driver);
		driver.manage().window().maximize();
		String actual=orderDetails.getTitleOfOrderDetailsPage();
		String expected="Order Details";
		Assert.assertEquals(actual, expected,"Wrong page is opened");
		String value2=orderDetails.getValueOfOrderId();
		Assert.assertEquals(value1, value2,Constant.errorMessageForVerifyDisplayOfOrderDetailsPage);
		
	}
	
}
