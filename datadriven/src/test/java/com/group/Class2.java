package com.group;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Class2 {
	@Test(groups = {"sanity","integration"})
	private void t3() {
		System.out.println("T3");
	}
	
	@Test(groups = {"sanity","integration"})
	private void t4() {
		System.out.println("T4");
	}
}
