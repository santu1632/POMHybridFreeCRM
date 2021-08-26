package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	ContactsPage contactsPage;
	Homepage homePage;
	TestUtil util;
	String sheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactsPage = new ContactsPage();
		util = new TestUtil();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		util.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactLabel(), "Contacts Page is not displayed");
	}

	@Test(priority = 2)
	public void selectContactsTest() {
		contactsPage.selectcontactsByName("01Kane William");
	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactsPage.selectcontactsByName("01Kane William");
		contactsPage.selectcontactsByName("Amar3 Singh3");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = util.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContactTest(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContact();
		// contactsPage.createNewContract("Mr.","santhosh","thondamal","WellsFargo");
		contactsPage.createNewContract(title, firstName, lastName, company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
