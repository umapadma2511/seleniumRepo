package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	
	public void setup()
	{
		initialization();
		homePage=new HomePage();
		loginPage=new LoginPage();
	}

	@Test(priority=1)
	public void HomePageTitleTest()
	{
		String title=homePage.ValidateHomePageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the Cloud FreeCRM");
		
	}
	
	@Test(priority=2)
	public void crmLogoTest()
	{
		boolean flag=homePage.validateLogo();
		Assert.assertTrue(flag);
		
	}
	@Test(priority=3)
	public void clickLoginBtn()
	{
		loginPage=homePage.clickLogin();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
