package simulator;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class base_simulator extends ExtentReportsDemo {

	public static DesiredCapabilities capabilities;
	public static URL url; 
	public static AppiumDriver<MobileElement>driver;


	@BeforeTest
	public static void setup() throws MalformedURLException {

		capabilities = new DesiredCapabilities();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("sessionName", "Automation test session"); 
		capabilities.setCapability("app", "/Users/yuanhanxu/Library/Developer/Xcode/DerivedData/KarateHealtDev-dbgsuhveekjjbieugtfnmwbwhegf/Build/Products/Debug-iphonesimulator/MSCorner.app");
		capabilities.setCapability("deviceName", "iPhone 11");
		capabilities.setCapability("platformVersion", "13.2"); 
		capabilities.setCapability("platformName", "iOS");

		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		driver = new AppiumDriver <MobileElement>(url, capabilities);
		String sessionId = driver.getSessionId().toString();

	}
}




