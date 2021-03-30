package com.denovo.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.denovo.Pages.LoginPage;
import com.denovo.base.TestBase;


public class LoginPageTest extends TestBase {
	LoginPage loginpage;


	public LoginPageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void validateloginpageTitle() {
		if(loginpage.verifyLoginPageTitle().equals("Denovo System")) {
			logger.info("LoginPage title Passed");
			Assert.assertTrue(true);

		}
		else {
			logger.info("LoginPage title failed");
			Assert.assertTrue(false);

		}
	}

	@Test(priority = 2)
	public void validatedenovologo() {
		boolean flag = loginpage.verifyDenovoLogo();
		Assert.assertTrue(flag);

	}

	@Test(priority =3 )
	public void validateRememberme() {
		loginpage.verifyRemembercheckbox();
		logger.info("Remembercheckbox is clicked");

	}

	@Test(priority = 4)
	public void validateloginbtn() {
		loginpage.verifylogin();
		logger.info("Login Is passed");

	}

	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(5000); 
		driver.quit();
	}
}