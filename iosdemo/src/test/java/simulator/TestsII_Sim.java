package simulator;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

public class TestsII_Sim extends Base_Sim {

	@Test(priority = 29, description = "New user - notifications pop-up", groups = {"Onboarding"})
	public void NewUser() throws IOException {

		driver.removeApp("com.karatehealth.app");
		driver.installApp("/Users/yuanhanxu/Documents/LupusCorner.app");
		driver.launchApp();
	}


	
	
	
	
	@Test(priority = 30, description = "Registration", groups = {"Registration"})
	@Parameters({"reg_email"})
	public void Reg(String reg_email) throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("settings icon")));
		driver.findElement(MobileBy.AccessibilityId("settings icon")).click();
		driver.findElement(MobileBy.AccessibilityId("settings")).click();
		driver.findElement(MobileBy.AccessibilityId("Register")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementStaticText' AND label == 'register'")));

		screen = "Register"; 
		captureScreenShots();

		driver.findElement(MobileBy.iOSClassChain("XCUIElementTypeWindow/**/XCUIElementTypeTextField[1]")).sendKeys(reg_email);
		driver.findElement(MobileBy.iOSClassChain("XCUIElementTypeWindow/**/XCUIElementTypeTextField[2]")).sendKeys(reg_email);
		driver.findElement(MobileBy.iOSClassChain("XCUIElementTypeWindow/**/XCUIElementTypeSecureTextField[1]")).sendKeys("123");
		driver.findElement(MobileBy.iOSClassChain("XCUIElementTypeWindow/**/XCUIElementTypeSecureTextField[2]")).sendKeys("123");

		screen = "Register-Text-Entry";
		captureScreenShots();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementButton' AND label == 'help'")).click(); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementStaticText' AND label == 'Got it!'")));

		screen = "Register-Help";
		captureScreenShots();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementButton' AND label == 'Got it!'")).click(); 
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementStaticText' AND label == 'register'")).click(); 


		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeNavigationBar' AND name == 'About'")));

		screen = "Edit-About"; 
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("backArrow")).click(); 
		driver.findElement(MobileBy.AccessibilityId("backArrow")).click(); 
	}

}
