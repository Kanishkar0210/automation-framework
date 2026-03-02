package com.testNG1;

import org.testng.annotations.Test;

public class Anotaions1 {
	
	
	
	@Test(priority = 1,groups = "Sanity" )
	private void t1() {
		System.out.println("One");

	}
	@Test(priority = 2,groups = "Regresstion" )
	private void t2() {
		System.out.println("Two");

	}
	
	
}
