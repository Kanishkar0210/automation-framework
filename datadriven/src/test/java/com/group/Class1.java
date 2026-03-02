package com.group;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Class1 {

	@Test(groups = {"sanity","integration"})
	private void t1() {
		System.out.println("T1");
	}
	
	@Test(groups = {"integration"})
	private void t2() {
		System.out.println("T2");
	}
	
}
