package iOS;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class base_iOS extends ExtentReportsDemo {
	
	public static DesiredCapabilities capabilities;
	public static URL url; 
	public static AppiumDriver<MobileElement>driver;


	@BeforeTest
	public static void setup() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities = new DesiredCapabilities();
	
		capabilities.setCapability("sessionName", "Automation test session");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("captureScreenshots", true);
		capabilities.setCapability("app", "kobiton-store:47615");
		capabilities.setCapability("groupId", 838); 
		capabilities.setCapability("deviceGroup", "KOBITON");
		capabilities.setCapability("deviceName", "iPhone XS Max");
		capabilities.setCapability("platformVersion", "12.1");
		capabilities.setCapability("platformName", "iOS");
		
		url = new URL("https://yuanhanxu:d393ddb6-983f-4c2c-b689-bf771d133d16@api.kobiton.com/wd/hub");
		driver = new AppiumDriver <MobileElement>(url, capabilities);
	
	}
}

