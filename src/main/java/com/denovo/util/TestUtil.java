package com.denovo.util;

import java.util.concurrent.TimeUnit;

import com.denovo.base.TestBase;

public class TestUtil extends TestBase{

	
	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

}