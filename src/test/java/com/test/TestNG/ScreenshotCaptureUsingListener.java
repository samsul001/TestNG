package com.test.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.commonUtil.baseTest;

public class ScreenshotCaptureUsingListener extends baseTest{

	@Test
	public void loginTest() {
		driver.get("https://www.ebay.com");
		driver.manage().window().maximize();
		Assert.assertTrue(false);
	}
}
