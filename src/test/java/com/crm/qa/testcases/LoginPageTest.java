package com.crm.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PersonalProfilePage;
public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	PersonalProfilePage personalProfilePage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void setup() {
		initialization();
		homePage=new HomePage();
		loginPage=new LoginPage();
	}

	@Test
	public void loginTest()
	{
		loginPage=homePage.clickLogin();
		personalProfilePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
  
	@AfterMethod()
	public void tearDown()
	{
	    driver.quit();
	}
}
