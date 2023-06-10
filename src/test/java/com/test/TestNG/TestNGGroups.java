package com.test.TestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGGroups {
	WebDriver driver;
	
	@BeforeClass(groups = {"smoke","SIT","regression"})
	public void startBrowser() {
		System.setProperty("WebDriver.driver.chromedriver", "D:\\workspace_selenium\\TestNG\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
	}
	
	@AfterClass(groups = {"smoke","SIT","regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority = 1,groups = {"smoke","SIT"})
	public void verifyTitle() {
		String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 2,groups = {"regression","SIT"})
	public void verifySearchText() {
		String expectedSearchText = "Search for anything";
		String actualSearchtext = driver.findElement(By.xpath("//input[@id='gh-ac']")).getAttribute("placeholder");
		System.out.println(actualSearchtext);
		Assert.assertEquals(expectedSearchText, actualSearchtext);
	}
	
	@Test(priority = 3,groups = {"regression","SIT"})
	public void verifySavedLink() {
		boolean actualSavedLinkPresence=driver.findElement(By.xpath("//a[text()='Saved']")).isDisplayed();
		System.out.println(actualSavedLinkPresence);
		Assert.assertEquals(actualSavedLinkPresence, true);
	}
	
	@Test(priority = 4,groups = {"regression","SIT"})
	public void verifyHomeLink() {
		boolean actualHomeLinkPresence = driver.findElement(By.xpath("//span[text()='Home']")).isDisplayed();
		System.out.println(actualHomeLinkPresence);
		Assert.assertEquals(actualHomeLinkPresence, true);
	}
	
	@Test(priority = 5,groups = {"regression","SIT"})
	public void verifyElectronicsLink() {
		boolean actualFashionLinkPresence = driver.findElement(By.xpath("//div[@id='mainContent']/descendant::a[text()='Electronics']")).isDisplayed();
		System.out.println(actualFashionLinkPresence);
		Assert.assertEquals(actualFashionLinkPresence, true);
	}
	
	@Test(priority = 6,groups = {"regression","SIT"})
	public void verifyFashionLink() {
		boolean actualFashionLinkPresence = driver.findElement(By.xpath("//div[@id='mainContent']/descendant::a[text()='Electronics']")).isDisplayed();
		System.out.println(actualFashionLinkPresence);
		Assert.assertEquals(actualFashionLinkPresence, true);
	}
	
	@Test(priority = 7,groups = {"regression","SIT"})
	public void verifyHealthLink() {
		boolean actualHealthLinkPresence=driver.findElement(By.xpath("//div[@id='mainContent']//descendant::a[contains(text(),'Health & Beauty')]")).isDisplayed();
		System.out.println(actualHealthLinkPresence);
		Assert.assertEquals(actualHealthLinkPresence, true);
	}
	
	@Test(priority = 8,groups= {"regression","SIT"})
	public void verifyHomeGarden() {
		boolean actualHomeLinkPresence=driver.findElement(By.xpath("//a[text()='Home & Garden']")).isDisplayed();
		System.out.println(actualHomeLinkPresence);
		Assert.assertEquals(actualHomeLinkPresence, true);
		
	}
	@Test(priority = 9, groups= {"regression","SIT"})
	public void verifySports() {
		boolean actualSportsLinkPresence = driver.findElement(By.xpath("//a[text()='Sports']")).isDisplayed();
		System.out.println(actualSportsLinkPresence);
		Assert.assertEquals(actualSportsLinkPresence, true);
	}
	
	@Test(priority = 10, groups= {"regression","SIT"})
	public void verifyCollection() {
		boolean actualCollectionLinkPresence = driver.findElement(By.xpath("//a[text()='Collectibles and Art']")).isDisplayed();
		System.out.println(actualCollectionLinkPresence);
		Assert.assertEquals(actualCollectionLinkPresence, true);
	}
	
	@Test(priority = 11, groups= {"regression","SIT"})
	public void verifyIndustrialEquipement() {
		boolean actualIndustrialEquipmentLinkPresence = driver.findElement(By.xpath("//a[text()='Industrial equipment']")).isDisplayed();
		System.out.println(actualIndustrialEquipmentLinkPresence);
		Assert.assertEquals(actualIndustrialEquipmentLinkPresence, true);
	}
	
	@Test(priority = 12, groups= {"regression","SIT"})
	public void verifyMotors() {
		boolean actualMotorsLinkPresence = driver.findElement(By.xpath("//a[text()='Motors']")).isDisplayed();
		System.out.println(actualMotorsLinkPresence);
		Assert.assertEquals(actualMotorsLinkPresence, true);
	}
	
	@Test(priority = 13, groups= {"regression","SIT"})
	public void verifyDeals() {
		boolean actualDealsLinkPresence = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[11]/a")).isDisplayed();
		System.out.println(actualDealsLinkPresence);
		Assert.assertEquals(actualDealsLinkPresence, true);
	}
	
	@Test(priority = 14, groups= {"regression","SIT"})
	public void verifySell() {
		boolean actualSellLinkPresence = driver.findElement(By.xpath("//a[text()='Sell']")).isDisplayed();
		System.out.println(actualSellLinkPresence);
		Assert.assertEquals(actualSellLinkPresence, true);
	}
	
	
	@Test(priority = 15,groups = {"smoke","SIT"})
	public void verifyButtonText() {
		String expectedButtonText = "Search";
		String actualButtonText = driver.findElement(By.xpath("//input[@id='gh-btn']")).getAttribute("value");
		System.out.println(actualButtonText);
		Assert.assertEquals(actualButtonText, expectedButtonText);
	}

}
