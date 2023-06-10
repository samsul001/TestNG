package com.test.commonUtil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class baseTest {
	public static WebDriver driver;
	@BeforeSuite
	public void startBrowser() {
		System.setProperty("webdriver.gecko.driver", "D:\\workspace_selenium\\TestNG\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3200, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
