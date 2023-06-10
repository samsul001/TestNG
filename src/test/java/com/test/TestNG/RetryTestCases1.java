package com.test.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.commonUtil.baseTest;

public class RetryTestCases1 extends baseTest{
	
	@Test(retryAnalyzer = com.test.commonUtil.Retry.class)
	public void ebayHomePage() {
		driver.get("https://www.ebay.com");
		//driver.manage().window().maximize();
		Assert.assertTrue(false);
	}

}
