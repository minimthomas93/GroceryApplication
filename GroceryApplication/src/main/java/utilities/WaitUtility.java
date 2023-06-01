package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	//add all explicit wait here
	
	public void waitForElementClickable(WebElement element,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForAnElementSelected(WebElement element,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	public void waitForAnElementSelectionState(WebElement element,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
	}
	
	public void waitForPage(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(2000));
	}
}
