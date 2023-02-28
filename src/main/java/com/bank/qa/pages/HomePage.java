package com.bank.qa.pages;

import java.awt.Desktop.Action;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;
import com.bank.qa.utils.TestUtil;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//i[@class='users icon']")
	WebElement contactsLink;
	
	@FindBy(xpath = "(//div[@class='menu-item-wrapper']/button)[2]")
	WebElement newContactPlusBtn;
	
	@FindBy(linkText = "Deals")
	WebElement dealsLink;
	
	@FindBy(linkText = "Tasks")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public void mouseHoveronContactsLink() {
		TestUtil.mouseHover(contactsLink);
	}
	
	public void clickOnNewContactPlusBtn() {
		TestUtil.mouseHover(contactsLink);
		//newContactPlusBtn.click();
	}
	
	public ContactsPage clickOnContact() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	
	public DealsPage clickOnDeals() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() {
		dealsLink.click();
		return new TasksPage();
	}

}
