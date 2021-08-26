package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Pagefactory or OR
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement crmLogo;
	
	//Initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	///Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Homepage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		
		return new Homepage();
	}
	
	public boolean  validateCRMLogo() {
		return crmLogo.isDisplayed();
	}

}
