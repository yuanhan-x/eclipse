package android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class Base_Android {

	public static DesiredCapabilities capabilities;
	public static URL url; 
	public static AppiumDriver<MobileElement>driver;


	@BeforeTest
	public static void setup() throws MalformedURLException {

		capabilities = new DesiredCapabilities();

		capabilities.setCapability("sessionName", "Automation test session");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("captureScreenshots", true);
		capabilities.setCapability("app", "kobiton-store:47612");
		capabilities.setCapability("groupId", 838); // Group: QA Team
		capabilities.setCapability("deviceGroup", "KOBITON");
		capabilities.setCapability("deviceName", "Pixel 3 XL");
		capabilities.setCapability("platformVersion", "10");
		capabilities.setCapability("platformName", "Android");
	
		url = new URL("https://yuanhanxu:d393ddb6-983f-4c2c-b689-bf771d133d16@api.kobiton.com/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, capabilities);
	}
}






