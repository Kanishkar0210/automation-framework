package com.testNG1;

import org.testng.annotations.Test;

public class Class2 {

	
	
	@Test(priority = 1,groups = "Regresstion" )
	private void t3() {
		System.out.println("Three");

	}
	@Test(priority = 2 ,groups = "Sanity")
	private void t4() {
		System.out.println("Four");

	}
	
}
