package simulator;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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

	@BeforeTest
	public static void setup() throws MalformedURLException {

		capabilities = new DesiredCapabilities();
		capabilities.setCapability("sessionName", "Automation test session"); 
		capabilities.setCapability("app", "/Users/yuanhanxu/Documents/LupusCorner.app");
		capabilities.setCapability("deviceName", "iPhone 11");
		capabilities.setCapability("platformVersion", "13.2"); 
		capabilities.setCapability("platformName", "iOS");

		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		driver = new IOSDriver <MobileElement>(url, capabilities);

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




