package com.test.TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAnnotations extends TestAnnotations1 {
		
	@Test(priority = 1, groups = "Regression")
	public void bestSellerLinkValidation() {
		System.out.println("Test 1");
		String actualBestSellerLinkText = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Best Sellers']")).getText();
		Assert.assertEquals(actualBestSellerLinkText, "Best Sellers");
		driver.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Best Sellers']")).click();
		String getTextOfSeller = driver.findElement(By.xpath("//*[@id='zg_banner_text_wrapper']")).getText();
		Assert.assertEquals(getTextOfSeller, "Amazon Bestsellers");
	}
	
	@Test(priority = 2, groups = "Regression")
	public void mobileLinkValidation() {
		System.out.println("Test 2");
		String actualMobileLinkValidation = driver.findElement(By.xpath("//a[text()='Mobiles']")).getText();
		Assert.assertEquals(actualMobileLinkValidation, "Mobiles");
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		String getTextofMobilesLink = driver.findElement(By.xpath("//div[@id='nav-subnav']//descendant::span[contains(text(),'Mobiles')]")).getText();
		Assert.assertEquals(getTextofMobilesLink, "Mobiles & Accessories");
	}
	
	@Test(priority = 3, groups = "Regression")
	public void fashionLinkValidation() {
		System.out.println("Test 3");
		String actualFashionLinkValidation = driver.findElement(By.xpath("//a[text()='Fashion']")).getText();
		Assert.assertEquals(actualFashionLinkValidation, "Fashion");
		driver.findElement(By.xpath("//a[text()='Fashion']")).click();
		String getTextofFashionLink = driver.findElement(By.xpath("//div[@id='nav-subnav']//descendant::span[contains(text(),'Women')]")).getText();
		Assert.assertEquals(getTextofFashionLink, "Women");
	}
	
	@Test(priority = 4,groups = "Regression")
	public void electronicsLinkValidation() {
		System.out.println("Test 4");
		String actualElectronicsLinkValidation = driver.findElement(By.xpath("//a[text()=' Electronics ']")).getText();
		Assert.assertEquals(actualElectronicsLinkValidation, "Electronics");
		driver.findElement(By.xpath("//a[text()=' Electronics ']")).click();
		String getTextofElectornicsText = driver.findElement(By.xpath("//div[@id='s-refinements']/div[1]/ul[1]/li[1]/span")).getText();
		Assert.assertEquals(getTextofElectornicsText, "Electronics");
	}
}
