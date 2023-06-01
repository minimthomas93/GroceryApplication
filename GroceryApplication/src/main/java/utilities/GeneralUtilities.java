package utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public boolean isElementPresent(WebElement element) {
		boolean value = element.isDisplayed();
		return value;
	}

	public String selectValueFromDropdown(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		WebElement selectedValue = select.getFirstSelectedOption();
		String textSelected = selectedValue.getText();
		return textSelected;
	}

	public void enterAValue(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void clickAnElement(WebElement element) {
		element.click();
	}

	public void dismissAnAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void acceptAnAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void doubleClickAnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();

	}
	
	public void scrollPage(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
	}

}
