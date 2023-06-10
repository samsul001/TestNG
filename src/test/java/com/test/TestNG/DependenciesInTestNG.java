package com.test.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

//You can use the attributes dependsOnMethods or dependsOnGroups, found on the @Test annotation.
//There are two kinds of dependencies:
//Hard dependencies: All the methods you depend on must have run and succeeded for you to run. 
//If at least one failure occurred in your dependencies, you will not be invoked and marked as a SKIP in the report.

//Soft dependencies: You will always be run after the methods you depend on, even if some of them have failed. 
  //This is useful when you just want to make sure that your test methods are run in a certain order but 
  //their success doesn't really depend on the success of others. 
  //A soft dependency is obtained by adding "alwaysRun=true" in your @Test annotation

//dependsOnMethods - can directly assign attributes to the method which ll be the dependent
//dependsOnGroups - can assign this by using xml
public class DependenciesInTestNG {
	
	@Test(groups = "Regression1")
	public void test1() {
		System.out.println("This is test1");
		Assert.assertTrue(false);
	}
	
	@Test(groups = "Regression1")
	public void test2() {
		System.out.println("This is test2");
	}
	
	@Test(dependsOnGroups = "Regression1")
	public void test3() {
		System.out.println("This is test3");
	}

	
	@Test(dependsOnMethods = "test1", alwaysRun = true)
	public void test4() {
		System.out.println("This is test4");
	}

	
	@Test(groups = "Regression1")
	public void test5() {
		System.out.println("This is test5");
	}
	
	@Test(dependsOnMethods = "test1")
	public void test6() {
		System.out.println("This is test6");
	}
	
	@Test(dependsOnMethods = "test1")
	public void test7() {
		System.out.println("This is test7");
	}
	


	

}
