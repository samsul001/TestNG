package com.test.TestNG;

import java.net.DatagramPacket;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	
	WebDriver driver;
	
	//@Test(dataProvider = "dataSet")
	public void test1(String username, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace_selenium\\TestNG\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Thread.sleep(3000);
		driver.close();
	}
	
	//@Test(dataProvider = "testData1", dataProviderClass = dataProvider.class)
	public void test2(String a, String b) {
		System.out.println(a+ "======" +b);
	}
	
	//@Test(dataProvider = "dataSet1", dataProviderClass = dataProvider.class)
	public void test3(String c, String d, String e) {
		System.out.println(c+" ==== "+d+" ==== "+e);
	}
	
	@Test(dataProvider = "testData", dataProviderClass = DataProvider2.class)
	public void loginTest(String a, String b) {
		System.out.println(a+"  "+b);
	}
	
	@Test(dataProvider = "testData", dataProviderClass = DataProvider2.class)
	public void loginTest1(String a, String b, String c) {
		System.out.println(a+"  "+b+"  "+c);
	}
	
	@DataProvider
	public Object[][] dataSet() {
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"}
		};
		}
	
	
	}


