package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//select[@name='title']")
	WebElement title_DD;
	
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='surname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath = "//input[@value='Save']")
	WebElement btnSave;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectcontactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+"//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox']")).click();
	}
	
	public void createNewContract(String title, String ftName, String ltName, String comp) {
		Select select = new Select(title_DD);
		select.selectByVisibleText(title);
		
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		btnSave.click();
		
		
	}
	
}
