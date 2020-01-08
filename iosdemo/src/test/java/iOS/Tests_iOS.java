package iOS;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;

public class Tests_iOS extends Base_iOS {

	@Test(priority = 1, description = "login to run tests", groups = {"Login"})
	public void login() throws IOException  {

		screen = "Start-Up-Screen";
		captureScreenShots();

		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("sign in")));
		driver.findElement(By.name("sign in")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("XCUIElementTypeTextField")));
		screen = "Sign in";
		captureScreenShots();

		driver.findElement(By.className("XCUIElementTypeTextField")).click();
		driver.findElement(By.className("XCUIElementTypeTextField")).sendKeys("tx1@");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("XCUIElementTypeSecureTextField")));
		driver.findElement(By.className("XCUIElementTypeSecureTextField")).click();
		driver.findElement(By.className("XCUIElementTypeSecureTextField")).sendKeys("123");

		driver.findElementByAccessibilityId("log in").click();
		driver.findElementByAccessibilityId("log in").click();
	}

	@Test(priority = 2, description = "view and dismiss the welcome pop-up in calendar",dependsOnMethods = "login", groups = {"Calendar"})
	public void welcome() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Calendar'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Calendar'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("later")));
		driver.findElementByAccessibilityId("later");

		screen = "Home-First-Time";
		captureScreenShots(); 

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("later")));
		driver.findElementByAccessibilityId("later").click(); 
	}

	@Test(priority = 3, description = "view the medications tab in calendar", dependsOnMethods = "login", groups = {"Calendar"})
	public void CalendarMed() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Calendar'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Calendar'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Medications")));

		screen = "Home-Calendar";
		captureScreenShots();
	}
	@Test(priority = 4, description = "view the activity tab in calendar", dependsOnMethods = "login", groups = {"Calendar"})
	public void CalendarAct() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Calendar'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Calendar'")).click();

		driver.findElement(By.name("Activity")).click(); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Activity")));

		screen = "Home-Calendar-Activity";
		captureScreenShots();
	} 

	@Test(priority = 5, description = "view the active meds tab without any medications", dependsOnMethods = "login", groups = {"Medications"})
	public void MedActEmp() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'log your medications'")));

		screen = "Medications-Active-Empty"; 
		captureScreenShots();

	}

	@Test(priority = 6, description = "view the past meds tab without any medications", dependsOnMethods = "login", groups = {"Medications"})
	public void MedPstEmp() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")).click();	

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Past'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Past'")));

		screen = "Medications-Past-Empty";
		captureScreenShots();

	}

	@Test(priority = 7, description = "add a new medication", dependsOnMethods = "login", groups = {"Medications"})
	public void MedAdd() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")).click();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Item'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Search for Medication"))); 

		screen = "Add Medication - Step 1 - Select Med";
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("Search for Medication")).sendKeys("Prascend");
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'Prascend'")));

		screen = "Add Medication - Step 1 - Search";
		captureScreenShots();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'Prascend'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'next'"))); 

		screen = "Add Medication - Step 2 - Med Details";
		captureScreenShots();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'next'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'save'")));

		screen = "Add Medication - Step 3 - Daily";
		captureScreenShots();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'save'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'okay!'")));

		screen = "Add Medication - Step 3 - Added";
		captureScreenShots();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'okay!'")).click();
	}

	@Test(priority = 8, description = "review a scheduled medication", dependsOnMethods = "MedAdd", groups = {"Medications"})
	public void MedRev() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")).click();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'Prascend'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Overview'")));

		screen = "Medications-Overview";
		captureScreenShots();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Log'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Log'")));

		screen = "Medications-Log";
		captureScreenShots();

		/*driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Info'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'okay!'")));

		screen = "Medications - Generic Name";
		captureScreenShots();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'Okay'")).click();

		screen = "Medications Info";
		captureScreenShots(); */

		driver.findElement(MobileBy.AccessibilityId("backArrow")).click();	

	}

	@Test(priority = 9, description = "take a scheduled medication", dependsOnMethods = "MedAdd", groups = {"Medications"})
	public void MedTake() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")).click();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'Prascend'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Overview'")));

		driver.findElement(MobileBy.AccessibilityId("Take")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("great!")));

		screen = "Medications-Take";
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("great!")).click();
		driver.findElement(MobileBy.AccessibilityId("backArrow")).click();	

	}

	@Test(priority = 10, description = "view the active meds tab", dependsOnMethods = "login", groups = {"Medications"})
	public void MedAct() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Active'")));

		screen = "Medications-Active";
		captureScreenShots();
	}
	
	@Test(priority = 11, description = "remove a scheduled medication", dependsOnMethods = "MedAdd", groups = {"Medications"})
	public void MedRem() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")).click();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'Prascend'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Overview'")));

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'remove medication'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'remove'")));

		screen = "Medications-Remove";
		captureScreenShots();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'remove'")).click();

	}

	@Test(priority = 12, description = "view the past meds tab", dependsOnMethods = "login", groups = {"Medications"})
	public void MedPst() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Past'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Past'")).click();

		screen = "Medications-Past"; 
		captureScreenShots();
	}

	@Test(priority = 13, description = "View the track homepage without check-ins", dependsOnMethods = "login", groups = {"Track"})
	public void TrackNew() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Track'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Track'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'log your side effects'")));

		screen = "Track-EmptySet";
		captureScreenShots();	

	}
	@Test(priority = 14, description = "Add new check-in", dependsOnMethods = "login", groups = {"Track"})
	public void TrackAdd() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Track'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Track'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'log your side effects'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'log your side effects'")).click();

		driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[5]")).click();
		
		screen = "Check-In-Step1";
		captureScreenShots();

	}


}






