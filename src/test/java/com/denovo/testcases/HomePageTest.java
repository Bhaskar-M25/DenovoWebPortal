package com.denovo.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.denovo.Pages.HomePage;
import com.denovo.base.TestBase;

public class HomePageTest extends TestBase {
	HomePage homepage;


	public HomePageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		homepage= new HomePage();
	}

	@Test(priority = 1)
	public void loginpageTitle() {
		
		if(homepage.verifyLoginPageTitle().equals("Denovo System")) {
			logger.info("LoginPage title Passed");
			Assert.assertTrue(true);
		}
		else {
			logger.info("LoginPage title failed");
			Assert.assertTrue(false);
		}
	}

	@Test(priority =2 )
	public void validatelogo() {
		boolean flag= homepage.verifylogo();
		Assert.assertTrue(flag);

	}	

	@Test(priority = 3)
	public void validateusername() {
		homepage.verifyUserName();
	}
	
}