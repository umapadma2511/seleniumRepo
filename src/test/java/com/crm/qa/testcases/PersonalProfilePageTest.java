package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PersonalProfilePage;

public class PersonalProfilePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	PersonalProfilePage personalProfilePage;
	DealsPage dealsPage;
	ContactsPage contactsPage;
	
	public PersonalProfilePageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		homePage=new HomePage();
		loginPage=new LoginPage();
		personalProfilePage=new PersonalProfilePage();
		dealsPage=new DealsPage();
		contactsPage=new ContactsPage();
		loginPage=homePage.clickLogin();
		personalProfilePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyPageTitle()
	{
		String title=personalProfilePage.checkPageTitle();
		Assert.assertEquals(title, "CRM");
		System.out.println("successfully logged into user profile and the page title is "+title);
	}
	@Test(priority=2)
	public void checkLoggedUsername()
	{
		String username=personalProfilePage.loggedInUser();
		Assert.assertEquals(username, "uma padma");
		System.out.println("checked the username "+username);
	}
	@Test(priority=3)
	public void moveToDealsPage()
	{
	    dealsPage=personalProfilePage.clickOnDeals();
	    System.out.println("successfully clicked on deals link");
	}
	
	@Test(priority=4)
	public void moveToContactsPage()
	{
	    contactsPage=personalProfilePage.clickOnContacts();
	    System.out.println("successfully clicked on contacts link");
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
