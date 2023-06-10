package com.test.commonUtil;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners extends util implements ITestListener{
	

	public void onTestStart(ITestResult result) {
		System.out.println("on test start");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("on test Success");
	}

	public void onTestFailure(ITestResult result) {
		try {
			getScreenshot(result.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("on Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("on Test Failed But Within SuccessPercentage");
	}

	public void onStart(ITestContext context) {
		System.out.println("on Start");
	}

	public void onFinish(ITestContext context) {
		System.out.println("on Finish");
	}


}
