package com.test.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assertion {
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace_selenium\\TestNG\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void verifyTestTitle() {
		
		driver.get("https://www.ebay.com/");
		String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

}
