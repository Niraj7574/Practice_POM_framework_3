// This is comment added

package com.bank.qa.tests;

import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.HomePage;
import com.bank.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase {
	
	//In order to call TestBase class constructor we need use super keyword.
	public LoginPageTest() {
		super();
	}
	
	
	LoginPage lp;
	HomePage hp;
	
	
  @BeforeMethod
  public void setUp() {
	  initilization();
	  lp = new LoginPage();
  }
			  
  @Test(priority = 1)
  public void LoginPageTitleTest() {
	  Assert.assertEquals(lp.validateLoginPageTitle(), "Cogmento CRM", "Login Page Title is Wrong");
  }

  @Test(priority = 2)
  public void LoginTest() {
	  hp = lp.login(prop.getProperty("Email"), prop.getProperty("Password"));
  }
  
  @AfterMethod
  public void teardown() {
	  driver.close();
  }

}
