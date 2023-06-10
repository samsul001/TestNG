package com.test.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListnersTest {
	WebDriver driver;
	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace_selenium\\TestNG\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void loginTest() {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		String actualTextOfProducts = driver.findElement(By.xpath("//div[@id='header_container']//descendant::span[contains(text(),'Products')]")).getText();
		Assert.assertEquals(actualTextOfProducts, "PRODUCTS");
	}
	
	@Test(priority = 2)
	public void burgerMenuValiation() {
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		String actualTextOfAllItems = driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']")).getText();
		System.out.println(actualTextOfAllItems);
		Assert.assertEquals(actualTextOfAllItems, "All Items");
		driver.findElement(By.xpath("//button[@id='react-burger-cross-btn']")).click();
	}
	


}
