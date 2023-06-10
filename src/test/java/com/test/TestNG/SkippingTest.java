package com.test.TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SkippingTest {

	WebDriver driver;
	boolean dataSetup = true;

	@BeforeClass
	public void startBrowser() {
		System.setProperty("WebDriver.driver.chromedriver", "D:\\workspace_selenium\\TestNG\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");
		driver.findElement(By.xpath("//div[@id='mainContent']//descendant::a[text()='Electronics']")).click();

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyTotalImageLinks() {
		List<WebElement> imgLinks= driver.findElements(By.cssSelector("img.b-img"));
		int noOfImgLinks = imgLinks.size();
		System.out.println("Total image links in Electronics: "+noOfImgLinks);
		Assert.assertEquals(noOfImgLinks, 10);
		driver.findElement(By.xpath("//div[contains(text(),'Cell Phones')]")).click();
	}

	@Test(priority = 2)
	public void valiatingCellText() {
		String expectedCellText ="Cell Phones & Smartphones";
		String actualCellText = driver.findElement(By.xpath("//div[contains(text(),'Cell Phones')]")).getText();
		Assert.assertEquals(actualCellText, expectedCellText);
	}

	@Test(priority = 3)
	public void validatingWatchesText() {
		String expectedWatchesText ="Smart Watches";
		String actualWatchesText = driver.findElement(By.xpath("//div[contains(text(),'Smart Watches')]")).getText();
		Assert.assertEquals(expectedWatchesText, actualWatchesText);
	}

	@Test(priority = 4)
	public void clickeBayTonavigateBack() {

		String expectedText = "Cell Phones, Smart Watches & Accessories";
		String actualText = driver.findElement(By.xpath("//span[text()='Cell Phones, Smart Watches & Accessories']")).getText();
		Assert.assertEquals(actualText, expectedText);
		driver.findElement(By.xpath("//a[text()='eBay']")).click();

	}

	@Test(priority = 5,enabled = false)
	public void homePageValidation() {
		String validatingHomeLinkText = driver.findElement(By.xpath("//span[text()='Home']")).getText();
		Assert.assertEquals(validatingHomeLinkText, "Home");
	}

	@Test(priority = 6)
	public void savedTextValidation() {
		String actualSavedText = driver.findElement(By.xpath("//a[text()='Saved']")).getText();
		Assert.assertEquals(actualSavedText, "Saved");
		throw new SkipException("this method will be skipped for some testing purpose");
	}

	@Test(priority = 7)
	public void dailyDealsLinkValiation() {
		if(dataSetup==false) {
			String actualDailyLinkText = driver.findElement(By.xpath("//a[text()=' Daily Deals']")).getText();
			Assert.assertEquals(actualDailyLinkText, "Daily Deals");
		}
		else {
			throw new SkipException("This is skipped because datasetup is failed");
		}
	}

	@Test(priority = 8)
	public void helpLinkValidation() {
		if(dataSetup==true) {
			System.out.println("datasetup is passed");
		}
		else {
			String actualHelpLinkText = driver.findElement(By.xpath("//a[text()='Help & Contact']")).getText();
			Assert.assertEquals(actualHelpLinkText, "Help & Contact");

		}
	}





}
