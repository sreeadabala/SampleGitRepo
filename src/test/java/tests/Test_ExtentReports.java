package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_ExtentReports {

	@Test
	public void test1() throws Exception {
		ExtentReports report = new ExtentReports("C:\\Users\\suman\\k17\\DDD\\target\\report.html");
		ExtentTest test = report.startTest("testcase 1");

		WebDriverManager.chromedriver().setup();
		test.log(LogStatus.INFO, "browser driver has been set");
		WebDriver driver = new ChromeDriver();
		test.log(LogStatus.INFO, "launch chrome browser");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "maximized browser");
		driver.get("https://mvnrepository.com/artifact/junit/junit/4.12");
		test.log(LogStatus.INFO, "url invoked");

		if (driver.findElement(By.xpath("//div[@id='logo']//a//img")).isDisplayed()) {
			test.log(LogStatus.PASS, "into homepage"
		+ test.addScreenCapture(captueScreenShot(driver, "homepage")));
		} else {
			test.log(LogStatus.FAIL, "not into home page"
					+ test.addScreenCapture(captueScreenShot(driver, "homepage")));
		}
		driver.quit();
		test.log(LogStatus.INFO, "close browser");
		report.endTest(test);
		report.flush();
		report.close();
	}

	private String captueScreenShot(WebDriver driver, String name) throws Exception {
		String path = "C:\\Users\\suman\\k17\\DDD\\target\\" + name + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(path));
		return path;
	}

}
