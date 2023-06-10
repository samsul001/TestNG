package com.test.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertion {
WebDriver driver;
SoftAssert softassert;
	
	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace_selenium\\TestNG\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void verifyTestTitle() {
		softassert = new SoftAssert();
		driver.get("https://www.ebay.com/");
		String expectedTitle = "Electronics, Cars, Fashion, Colle11ctibles & More | eBay";
		String actualTitle = driver.getTitle();
		softassert.assertEquals(actualTitle, expectedTitle,"Test Assertion Passed");
		System.out.println("Check1 - passed");
		
		
		String expectedButtonText = "Search";
		String actualButtonText = driver.findElement(By.xpath("//input[@id='gh-btn']")).getAttribute("value");
		softassert.assertEquals(actualButtonText, expectedButtonText,"Test Assertion Passed");
		System.out.println("Check2 - passed");
		
		softassert.assertAll();
	}

}
