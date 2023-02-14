package com.bank.qa.tests;

import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.ContactsPage;
import com.bank.qa.pages.HomePage;
import com.bank.qa.pages.LoginPage;
import com.bank.qa.utils.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ContactsPageTest extends TestBase{
		
	  LoginPage lp;
	  HomePage hp;
	  ContactsPage cp;
	 
	 public ContactsPageTest() {
		super();
	}
	  
	 @BeforeMethod
	  public void setUp() {
		 initilization();
		 lp = new LoginPage();
		 hp = lp.login(prop.getProperty("Email"), prop.getProperty("Password"));
		 cp = hp.clickOnContact();
	}
	
  @Test(priority = 1)
  public void verifyContactPageLabelTest() {
		Assert.assertTrue(cp.verifyContactLabel(), "Contact pas is not matched");
  }
  
  @Test(priority = 2)
  public void verifyCreateNewContactLabelTest() {
	  	cp.clickOnCreateNewContactBtn();
		Assert.assertTrue(cp.verifyCreateNewContactLabel(), "Contact pas is not matched");
  }
  
  @DataProvider 
  public Object[][] getCrmTestData() {
	  Object data[][] = TestUtil.getTestData("contacts");
	  return data;
  }
  
  @Test(priority = 3, dataProvider = "getCrmTestData")
  public void createNewContactTest(String fName, String lName) throws InterruptedException {
	  cp.clickOnCreateNewContactBtn();
	  Thread.sleep(2000);
	  driver.navigate().refresh();
	  cp.createNewContact(fName, lName);
  }
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
