package com.denovo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.denovo.base.TestBase;

public class HomePage extends TestBase{

	//Page Factory
	@FindBy(xpath="//span[contains(text(),'User Management')]")
	WebElement usermanage;


	@FindBy(xpath="//p[contains(text(),'Denovo Admin')]")
	WebElement username;
	
	@FindBy(xpath="//*[@class='sidebar-brand']/img")
	WebElement logo; 
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifylogo() {
		return logo.isDisplayed();
		
	}	
	

	public String verifyUserName() {
		return username.getText();
	}

	
	public UserManagementPage usermanage() {
		
		return new UserManagementPage();
			
		}
	}


