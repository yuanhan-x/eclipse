package iOS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import iOS.base_iOS;
import io.appium.java_client.MobileElement;

public class tests_iOS extends base_iOS {
	
	@Test(description = "Launch app and tap sign in")
	public void login1() throws InterruptedException {
		
		MobileElement one = (MobileElement) driver.findElement(By.name("sign in"));
		one.click();
	}

	@Test(description = "Find email field and enter valid email address")
	public void test_2() {

		MobileElement two = (MobileElement) driver.findElement(By.id("73000000-0000-0000-A90A-000000000000"));
		two.click();
		two.sendKeys("test@test.com");
	}

	@Test(description = "Find password field and enter valid password")
	public void test_3() {

		MobileElement three = (MobileElement) driver.findElement(By.name("backArrow"));
		three.click();
		three.sendKeys("123");

	}

	@Test(description = "Log in")
	public void test_4() {

		MobileElement four = (MobileElement) driver.findElement(By.name("Log in"));
		four.click();
	}

	@AfterTest
	public void after() {
		driver.quit();
		
	}
}

