package com.test.TestNG;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Priority;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;


public class TestListeners {
	
	@Test(priority = 1)
	public void test1() {
		Date currentDate =new Date();
		System.out.println(currentDate.toString());
		String text = currentDate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(text);
		Assert.assertTrue(true);
	}
	
	@Test(priority = 2)
	public void test2() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String screenshotName ="tc_001"+timeStamp;
		System.out.println(screenshotName);
		Assert.assertTrue(true);
	}
	
	@Test(priority = 3)
	public void test3() {
		System.out.println("pass");
	}
	
	@Test(priority = 4)
	public void test4() {
		System.out.println("fail");
	}
	
	@Test(priority = 5)
	public void test5() {
		System.out.println("fail");
		throw new SkipException("this method will be skipped");
	}
	

}
