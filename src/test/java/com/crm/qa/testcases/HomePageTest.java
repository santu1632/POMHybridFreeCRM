package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	Homepage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	TestUtil util;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		util = new TestUtil();
		loginpage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePagetitle() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page Title Not Matched");
	}

	@Test(priority = 2)
	public void verifyLoggedInUser() {
		util.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName(), "User Not Logged In");
	}

	@Test(priority = 3)
	public void verifyContactPageLink() {
		util.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
