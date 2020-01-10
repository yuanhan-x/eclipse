package simulator;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Base_Sim {

	public static DesiredCapabilities capabilities;
	public static URL url; 
	public static AppiumDriver<MobileElement>driver;

	String folder_name; 
	String screen;
	WebDriverWait wait;

	@BeforeTest(alwaysRun = true)
	@Parameters({"platform", "version", "udid", "deviceName", "wdaLocalPort"})
	public static void setup(String platform, String version, String udid, String deviceName, String wdaLocalPort) throws MalformedURLException {

		capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", platform);
		capabilities.setCapability("platformVersion", version); 
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("udid", udid);
		capabilities.setCapability("sessionName", "Appium"); 
		capabilities.setCapability("app", "/Users/yuanhanxu/Documents/LupusCorner.app");
		capabilities.setCapability("showXcodeLog", true);
		capabilities.setCapability("wdaLocalPort", wdaLocalPort);
		capabilities.setCapability("noRESET", true);

		URL url = new URL("http://127.0.0.1:4723/wd/hub/"); 
		driver = new AppiumDriver <MobileElement>(url, capabilities);
		
	}
	
	public void captureScreenShots() throws IOException {
		folder_name=driver.getSessionDetail("deviceName").toString();
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		new File(folder_name).mkdir();
		String file_name= screen + ".png";
		FileUtils.copyFile(f, new File(folder_name + "/" + file_name)); 
	}

	/*@AfterTest
	public void teardown() {
		driver.quit();
	}*/
}




