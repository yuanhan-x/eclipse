package iOS;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class Base_iOS {

	public static DesiredCapabilities capabilities;
	public static URL url; 
	public static AppiumDriver<MobileElement> driver;
	String folder_name;
	String screen;
	WebDriverWait wait;


	@BeforeTest
	public static void setup() throws MalformedURLException{

		capabilities = new DesiredCapabilities();

		capabilities.setCapability("sessionName","");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("captureScreenshots", true);
		capabilities.setCapability("app", "kobiton-store:48677");
		capabilities.setCapability("groupId", 838);
		capabilities.setCapability("deviceGroup", "KOBITON");
		capabilities.setCapability("deviceName", "iPhone XS");
		capabilities.setCapability("platformVersion", "12.1.2");
		capabilities.setCapability("platformName", "iOS");

		try {
			url = new URL("https://yuanhanxu:d393ddb6-983f-4c2c-b689-bf771d133d16@api.kobiton.com/wd/hub");
			driver = new AppiumDriver <MobileElement>(url, capabilities);		
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}
	
	public void captureScreenShots() throws IOException {
		folder_name=driver.getSessionDetail("deviceName").toString();
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		new File(folder_name).mkdir();
		String file_name= screen + ".png";
		FileUtils.copyFile(f, new File(folder_name + "/" + file_name)); 
	}
	
	
}

