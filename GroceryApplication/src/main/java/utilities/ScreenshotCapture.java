package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenshotCapture{
	//WebDriver driver;
	
	public void takeScreenshotAtEndOfTest(String testCaseName, WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        String currentDir = System.getProperty("user.dir");
        
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +testCaseName+ System.currentTimeMillis() + ".png"));
    }

}


