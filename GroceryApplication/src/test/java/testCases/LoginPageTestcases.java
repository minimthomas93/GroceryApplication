package testCases;

import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import retry.Retry;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageTestcases extends BaseClass {

	LoginPage lp;
	DashboardPage home;
	public static Properties prop;
	
	@Test(enabled=false)
	public void verifyTextOfSigninButton() {

		lp = new LoginPage(driver);
		String actual = lp.verifySignInButtonText();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, Constant.errorMessageForVerifyTextOfSigninButton);

	}

	@Test(enabled=true,retryAnalyzer = retry.Retry.class)
	public void loginWithValidCredentials() {

		lp = new LoginPage(driver);
		//lp.performLogin("admin", "admin");
		prop=new Properties();
		lp.performLogin(prop.getProperty("username"), prop.getProperty("password"));
		home=new DashboardPage(driver);
		String actual = home.verifyTextOfDashboardElement();
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected, Constant.errorMessageForLoginWithValidCredentials);

	}

	@Test(enabled=false,dataProvider="LoginDetailsforloginWithInvalidCredentials",dataProviderClass=utilities.DataProvidersutility.class)
	public void loginWithInvalidCredentials(String uname,String pwd) {

		lp = new LoginPage(driver);
		lp.performLogin(uname,pwd);
		boolean actual = lp.verifyDisplayOfErrorMessage();
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.errorMessageForLoginWithInvalidCredentials);
	}

}
