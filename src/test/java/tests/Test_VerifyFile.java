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

public class Test_VerifyFile {

	@Test
	public void test1() throws Exception {
		File folder = new File("C:\\Users\\suman\\Downloads\\download\\");
		File files[] = folder.listFiles();
		boolean flag = false;
		loop: for (File f : files) {
			String name = f.getName();
			if (name.equals("test12.txt")) {
				flag = true;
				break loop;
			}
		}
		if (flag == true) {
			System.out.println("file downloaded");
		} else {
			System.out.println("file not downloaded");
		}
	}

}
