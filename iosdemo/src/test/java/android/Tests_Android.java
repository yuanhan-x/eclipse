package android;

import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import io.appium.java_client.MobileElement;

public class Tests_Android extends Base_Android {

	@Test(description = "Launch app and tap sign in")
	public void login1() {
		System.out.println("Android has been complete");
		MobileElement one = (MobileElement) driver.findElement(By.id("com.progentec.lupuscorner:id/signIn"));
		one.click();
}

	/*
	@Test(description = "Find email field and enter valid email address")
	public void test_2() {
		test = extent.createTest("Test two");
		test.log(Status.INFO, "Find email field and enter valid email address");

		MobileElement two = (MobileElement) driver.findElement(By.id("73000000-0000-0000-A90A-000000000000"));
		two.click();
		two.sendKeys("test@test.com");
	}

	@Test(description = "Find password field and enter valid password")
	public void test_3() {
		test = extent.createTest("Test three");
		test.log(Status.INFO, "Find password field and enter valid password");

		MobileElement three = (MobileElement) driver.findElement(By.name("backArrow"));
		three.click();
		three.sendKeys("123");

	}

	@Test(description = "Log in")
	public void test_4() {
		test = extent.createTest("Test four");
		test.log(Status.INFO, "Find log in button and log in");

		MobileElement four = (MobileElement) driver.findElement(By.name("Log in"));
		four.click();
	}

	 */

	@AfterTest
	public void after() {
		driver.quit();
	}

}

