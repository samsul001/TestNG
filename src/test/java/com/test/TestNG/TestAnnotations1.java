package com.test.TestNG;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class TestAnnotations1 {
	
	WebDriver driver;
	softAssertion softassert = new softAssertion();
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite is working");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite is working");
	}
	
	
	@BeforeTest(groups = {"Regression","smoke"})
	public void loginTest() {
		System.setProperty("webriver.chrome.driver", "D:\\workspace_selenium\\TestNG\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();	
		System.out.println("Before Test is working");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void startUrl() {
			
		System.out.println("Before Class is working");
	}
		
	
	@BeforeGroups(value = {"Regression"})
	public void validateTitle() {
		System.out.println("Before Groups: Test has started");
		String expectedTitleOfAmazon = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitleOfAmazon = driver.getTitle();
		Assert.assertEquals(actualTitleOfAmazon, expectedTitleOfAmazon);		
	}
	
	@BeforeMethod(groups = {"Regression","smoke"})
	public void TestExecutionStarted() {
		System.out.println("Before Method: Test Execution Started");
		
	}
	
	@AfterMethod(groups = {"Regression","smoke"})
	public void TestExecutionEnded() {
		System.out.println("After Method: Test Execution Ended");
		driver.navigate().back();
		
	}	
	
	@AfterTest(groups = {"Regression","smoke"})
	public void logOutTest() {
		driver.quit();
		System.out.println("After Test is working");
	}
	
	
	

}
