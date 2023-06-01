package testCases;

import org.testng.annotations.Test;

import utilities.ScreenshotCapture;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	WebDriver driver;
	public static Properties prop;
	ScreenshotCapture sc;

	public static void testBase() {

		{
			prop = new Properties();
			FileInputStream ip = null;
			try {
				ip = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void beforeMethod(String browser) {
		testBase();
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod(alwaysRun=true)
	public void afterMethod(ITestResult iTestResult) throws IOException {
		sc=new ScreenshotCapture();
		if(iTestResult.getStatus()==iTestResult.FAILURE)
		{
		sc.takeScreenshotAtEndOfTest(iTestResult.getName(),driver);
	}
		driver.close();
	}
}
