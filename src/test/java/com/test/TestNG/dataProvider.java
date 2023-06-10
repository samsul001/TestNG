package com.test.TestNG;

import org.testng.annotations.DataProvider;


public class dataProvider {
	
	//By Using dataProvider method and test method , we can do data driven testing
	//DataProvider annotated method contains data that will be feeded to test method
	// following are two ways to store data in DataProvider 

	@DataProvider(name = "testData1")
	public Object[][] dataSet(){

		Object[][] testData = new Object[4][2];

		//1st row of data
		testData[0][0] = "user1";
		testData[0][1] = "password1";

		//2nd row of data
		testData[1][0] = "user2";
		testData[1][1] = "password2";

		//3rd row of data
		testData[2][0] = "user3";
		testData[2][1] = "password3";

		//4th row of data
		testData[3][0] = "user4";
		testData[3][1] = "password4";
		
		return testData;
	}
	
	@DataProvider
	public Object[][] dataSet1(){
		return new Object[][] {
			{"username1","password1","test1"},
			{"username2","password2","test2"},
			{"username3","password3","test3"},
			{"username4","password4","test4"}
		};
	}

}
