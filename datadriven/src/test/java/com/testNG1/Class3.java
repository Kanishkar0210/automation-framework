package com.testNG1;

import org.testng.annotations.Test;

public class Class3 {
	@Test(priority = 1,groups = {"Regresstion","Sanity"}  )
	private void t5() {
		System.out.println("Five");

	}
	@Test(priority = 2,groups = {"Regresstion","Sanity"}  )
	private void t6() {
		System.out.println("Six");

	}

}
