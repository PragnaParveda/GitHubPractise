package extentreports.extentreports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;

	@BeforeTest
	public void config() {
		String path=System.getProperty("user.dir")+"//reports//indexreport.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web automation test results");
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pragna");
	}

	@Test
	public void initialDriver() {
		ExtentTest test=extent.createTest("Initial Demo");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/#/practice-project");
		System.out.println(driver.getTitle());
		test.fail("we failed the test expliciltly ");
		extent.flush();

	}
	
	public void print() {
		System.out.println("pragna");
	}

}
