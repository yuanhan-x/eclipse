package simulator;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import io.appium.java_client.MobileBy;

public class Tests_Sim extends Base_Sim {

	@Test(priority = 1, description = "login to run tests", groups = {"Login"})
	@Parameters({"email", "pw"})
	public void login(String email, String pw) throws IOException  {

		screen = "Start-Up-Screen";
		captureScreenShots();

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("sign in")));
		driver.findElement(By.name("sign in")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("XCUIElementTypeTextField")));
		screen = "Sign in";
		captureScreenShots();

		driver.findElement(By.className("XCUIElementTypeTextField")).click();
		driver.findElement(By.className("XCUIElementTypeTextField")).sendKeys(email);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("XCUIElementTypeSecureTextField")));
		driver.findElement(By.className("XCUIElementTypeSecureTextField")).click();
		driver.findElement(By.className("XCUIElementTypeSecureTextField")).sendKeys(pw);

		driver.findElementByAccessibilityId("log in").click();
		driver.findElementByAccessibilityId("log in").click();
	}

	@Test(priority = 2, description = "view and dismiss the welcome pop-up in calendar", groups = {"Calendar"})
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

	@Test(priority = 3, description = "view the medications tab in calendar", dependsOnGroups = {"Login"}, groups = {"Calendar"})
	public void CalendarMed() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Calendar'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Calendar'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Medications")));

		screen = "Home-Calendar";
		captureScreenShots();
	}
	@Test(priority = 4, description = "view the activity tab in calendar", dependsOnGroups = {"Login"}, groups = {"Calendar"})
	public void CalendarAct() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Calendar'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Calendar'")).click();

		driver.findElement(By.name("Activity")).click(); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Activity")));

		screen = "Home-Calendar-Activity";
		captureScreenShots();
	} 

	@Test(priority = 5, description = "view the active meds tab without any medications", dependsOnGroups = {"Login"}, groups = {"Medications"})
	public void MedActEmp() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'log your medications'")));

		screen = "Medications-Active-Empty"; 
		captureScreenShots();

	}

	@Test(priority = 6, description = "view the past meds tab without any medications", dependsOnGroups = {"Login"}, groups = {"Medications"})
	public void MedPstEmp() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")).click();	

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Past'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Past'")));

		screen = "Medications-Past-Empty";
		captureScreenShots();

	}

	@Test(priority = 7, description = "add a new medication", dependsOnGroups = {"Login"}, groups = {"Medications"})
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

	@Test(priority = 8, description = "view the active meds tab", dependsOnGroups = {"Login"}, groups = {"Medications"})
	public void MedAct() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Active'")));

		screen = "Medications-Active";
		captureScreenShots();
	}

	@Test(priority = 9, description = "review a scheduled medication", dependsOnMethods = "MedAdd", groups = {"Medications"})
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

	@Test(priority = 10, description = "take a scheduled medication", dependsOnMethods = "MedAdd", groups = {"Medications"})
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

	@Test(priority = 12, description = "view the past meds tab", dependsOnGroups = {"Login"}, groups = {"Medications"})
	public void MedPst() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Medications'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Past'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Past'")).click();

		screen = "Medications-Past"; 
		captureScreenShots();
	}

	@Test(priority = 13, description = "View the track homepage without a check-in", dependsOnGroups = {"Login"}, groups = {"w"})
	public void TrackNew() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Track'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Track'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'log your side effects'")));

		screen = "Track-EmptySet";
		captureScreenShots();	

	}
	@Test(priority = 14, description = "Add new check-in", dependsOnGroups = {"Login"}, groups = {"w"})
	public void TrackAdd() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Track'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Track'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'log your side effects'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'log your side effects'")).click();

		driver.findElement(MobileBy.iOSClassChain("XCUIElementTypeWindow/**/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther[1]")).click();

		screen = "Check-In-Step1";
		captureScreenShots();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'next'")).click();
		driver.findElement(MobileBy.AccessibilityId("Anemia")).click();
		driver.findElement(MobileBy.AccessibilityId("Anxiety")).click();
		driver.findElement(MobileBy.AccessibilityId("Bloating")).click();

		screen = "Check-In-Step2";
		captureScreenShots();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'next'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Severity")));

		screen = "Check-In-Step3";
		captureScreenShots();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'save'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("nice!")));

		screen = "Check-In-Step3-Popup";
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("nice!")).click();
	}

	@Test(priority = 15, description = "View the track homepage with a check-in", dependsOnGroups = {"Login"}, groups = {"Track"})
	public void TrackHome() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Track'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Track'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeNavigationBar' AND name == 'Track'")));

		screen = "Track-ReturningUser";
		captureScreenShots();
	}
	@Test(priority = 16, description = "Review a check-in", dependsOnGroups = {"Login"}, groups = {"Track"})
	public void TrackReview() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Track'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Track'")).click();

		driver.findElement(MobileBy.iOSNsPredicateString("type = 'XCUIElementTypeStaticText' AND label CONTAINS ':'")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeNavigationBar' AND name == 'Review Check In'")));

		screen = "Track-Review-Checkin";
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("backArrow")).click();	
	}

	@Test(priority = 17, description = "View the articles activity", dependsOnGroups = {"Login"}, groups = {"Articles"})
	public void Articles() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Articles'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Articles'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeNavigationBar' AND name == 'LupusCorner News'")));

		screen = "Articles";
		captureScreenShots();
	}

	@Test(priority = 18, description = "View the discuss activity", dependsOnGroups = {"Login"}, groups = {"Discuss"})
	public void DiscussHome() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Discuss'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Discuss'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeNavigationBar' AND name == 'Discuss'")));

		screen = "Discuss-Feed";
		captureScreenShots();
	}

	@Test(priority = 19, description = "Search for a post", dependsOnGroups = {"Login"}, groups = {"Discuss"})
	public void DiscussSearch() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Discuss'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Discuss'")).click();

		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeSearchField' AND label == 'Search Posts'")).click();
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeSearchField' AND label == 'Search Posts'")).sendKeys("Pain");
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeSearchField' AND label == 'Search Posts'")).sendKeys(Keys.ENTER);

		screen = "Discuss-SearchPost"; 
		captureScreenShots();
	}

	@Test(priority = 20, description = "Add a new post", dependsOnGroups = {"Login"}, groups = {"Discuss"})
	public void DiscussNew() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Discuss'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Discuss'")).click();

		driver.findElement(MobileBy.AccessibilityId("addPost")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeNavigationBar' AND name == 'New Post'")));

		screen = "Discuss-NewPost"; 
		captureScreenShots();

		driver.findElement(MobileBy.className("XCUIElementTypeSwitch")).click();

		screen = "Discuss-NewPost-Anonymous"; 
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("backArrow")).click();	
	}

	@Test(priority = 21, description = "Comment on a post", dependsOnGroups = {"Login"}, groups = {"Discuss"})
	public void DiscussComment() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Discuss'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Discuss'")).click();

		driver.findElement(MobileBy.iOSClassChain("XCUIElementTypeWindow/**/XCUIElementTypeTextView[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeNavigationBar' AND name == 'Comment'")));

		screen = "Discuss-Comment"; 
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("backArrow")).click();	
	}

	@Test(priority = 22, description = "View your notifications", dependsOnGroups = {"Login"}, groups = {"Discuss"})
	public void DiscussNotif() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Discuss'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND label == 'Discuss'")).click();

		driver.findElement(MobileBy.iOSClassChain("XCUIElementTypeWindow/**/XCUIElementTypeImage[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeNavigationBar' AND label == 'Notifications'")));

		screen = "Discuss-Notifications"; 
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("backArrow")).click();	
	}

	@Test(priority = 23, description = "View the Edit menu", dependsOnGroups = {"Login"}, groups = {"Edit"})
	public void EditHome() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("settings icon")));
		driver.findElement(MobileBy.AccessibilityId("settings icon")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("edit profile")));

		screen = "Edit"; 
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("backArrow")).click(); 
	}

	@Test(priority = 24, description = "Edit menu - edit profile", dependsOnGroups = {"Login"}, groups = {"Edit"})
	public void EditProf() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("settings icon")));
		driver.findElement(MobileBy.AccessibilityId("settings icon")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("edit profile")));
		driver.findElement(MobileBy.AccessibilityId("edit profile")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeNavigationBar' AND visible == true")));

		screen = "Edit-Profile"; 
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("backArrow")).click(); 
		driver.findElement(MobileBy.AccessibilityId("backArrow")).click(); 
	}

	@Test(priority = 25, description = "Edit menu - settings", dependsOnGroups = {"Login"}, groups = {"Edit"})
	public void EditSet() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("settings icon")));
		driver.findElement(MobileBy.AccessibilityId("settings icon")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("settings")));
		driver.findElement(MobileBy.AccessibilityId("settings")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeNavigationBar' AND name == 'Settings'")));

		screen = "Edit-Settings"; 
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("backArrow")).click(); 
		driver.findElement(MobileBy.AccessibilityId("backArrow")).click(); 
	}

	@Test(priority = 26, description = "Edit menu - about", dependsOnGroups = {"Login"}, groups = {"Edit"})
	public void EditAbout() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("settings icon")));
		driver.findElement(MobileBy.AccessibilityId("settings icon")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'about'")));
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'about'")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeNavigationBar' AND name == 'About'")));

		screen = "Edit-About"; 
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("backArrow")).click(); 
		driver.findElement(MobileBy.AccessibilityId("backArrow")).click(); 
	}

	@Test(priority = 27, description = "Terms & Conditions", dependsOnGroups = {"Login"}, groups = {"TC"})
	public void TC() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("settings icon")));
		driver.findElement(MobileBy.AccessibilityId("settings icon")).click();
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'about'")).click();
		driver.findElement(MobileBy.AccessibilityId("Terms & Conditions")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeNavigationBar' AND name == 'Terms and conditions list'")));

		screen = "Terms-Conditions";
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("backArrow")).click(); 
		driver.findElement(MobileBy.AccessibilityId("backArrow")).click(); 
		driver.findElement(MobileBy.AccessibilityId("backArrow")).click();
	}

	@Test(priority = 28, description = "Privacy Policy", dependsOnGroups = {"Login"}, groups = {"Privacy"})
	public void Privacy() throws IOException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("settings icon")));
		driver.findElement(MobileBy.AccessibilityId("settings icon")).click();
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'about'")).click();
		driver.findElement(MobileBy.AccessibilityId("Privacy")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeNavigationBar' AND name == 'Privacy Policy List'")));

		screen = "Privacy-Policy";
		captureScreenShots();

		driver.findElement(MobileBy.AccessibilityId("backArrow")).click(); 
		driver.findElement(MobileBy.AccessibilityId("backArrow")).click(); 
		driver.findElement(MobileBy.AccessibilityId("backArrow")).click();
	}
}


