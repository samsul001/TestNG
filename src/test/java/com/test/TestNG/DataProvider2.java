package com.test.TestNG;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProvider2 {

	//Create a dataProvider method and referring them to multiple test methods with required arguments with conditions

	
	
	@DataProvider
	public Object[][] testData(Method m){

		Object[][] testData = null;

		if(m.getName().equals("loginTest")) {
			testData = new Object[][] {
				{"username1","username1"},
				{"username2","username2"},
				{"username3","username3"},
				{"username4","username4"}
			};
		}

		else if(m.getName().equals("loginTest1")) {
			testData = new Object[][] {
				{"username1","password1","test1"},
				{"username2","password2","test2"},
				{"username3","password3","test3"},
				{"username4","password4","test4"}
			};
		}
		
		return testData;
	}

}
