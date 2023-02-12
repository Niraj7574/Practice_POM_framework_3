package com.bank.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(linkText = "Create")
	WebElement createNewContactBtn;
	
	@FindBy(xpath = "//span[contains(@class,'selectable')]")
	WebElement createNewContactLabel;
	
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstNameField;
	
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lasttNameField;
	
	@FindBy(xpath = "//div[@name='company']")
	WebElement company;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void clickOnCreateNewContactBtn() {
		createNewContactBtn.click();
	}
	
	public boolean verifyCreateNewContactLabel() {
		return createNewContactLabel.isDisplayed();
	}
	
	public void createNewContact(String fName, String lName) {
		firstNameField.sendKeys(fName);
		lasttNameField.sendKeys(lName);
		saveBtn.click();
	}
	

}
