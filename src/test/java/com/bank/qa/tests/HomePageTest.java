package com.bank.qa.tests;

import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.ContactsPage;
import com.bank.qa.pages.HomePage;
import com.bank.qa.pages.LoginPage;
import com.bank.qa.utils.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase {

	public HomePageTest() {
		super();
	}
	
  LoginPage lp;
  HomePage hp;
  ContactsPage cp;
  TestUtil util;
  	
  @BeforeMethod
  public void setUp() {
	 initilization();
	 lp = new LoginPage();
	 hp = lp.login(prop.getProperty("Email"), prop.getProperty("Password"));
	 cp = new ContactsPage();
  }	
	
 @Test(priority = 1)
  public void verifyHomePageTitleTest() {
	  String homePageTitle = hp.verifyHomePageTitle();
	  Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page Title not matched");
	  
  }

 @Test(priority = 2)
  public void verifyUserNameTest() {
	Assert.assertTrue(hp.verifyUserName(), "User name not matched");
 }
  
  @Test(priority = 3)
  public void verifyContactsLinkTest(){
	cp = hp.clickOnContact();
 }
  
  @Test(priority = 4)
  public void clickOnNewContactPlusBtnTest(){
	  hp.mouseHoveronContactsLink();
	  hp.clickOnContact();
	  cp.clickOnCreateNewContactBtn();
 }
  
  
  @AfterMethod
  public void tearDown() {
	  driver.close();
  }

}
