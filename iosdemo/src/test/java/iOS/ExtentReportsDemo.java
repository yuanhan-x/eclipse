package iOS;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemo {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public static void reportSetup() {
			
		htmlReporter = new ExtentHtmlReporter("extent.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);  
		
	}	

}


