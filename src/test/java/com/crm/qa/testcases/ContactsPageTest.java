package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PersonalProfilePage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	PersonalProfilePage personalProfilePage;
	ContactsPage contactsPage;
	
	public  ContactsPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		homePage=new HomePage();
		loginPage=new LoginPage();
		personalProfilePage=new PersonalProfilePage();
		contactsPage=new ContactsPage();
		loginPage=homePage.clickLogin();
		personalProfilePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		contactsPage=personalProfilePage.clickOnContacts();
	}
	
	@Test(priority=3)
	public void verifyContactsLabel()
	{
		Assert.assertTrue(contactsPage.checkContactsLabel(), "The contacts label is not displayed");
		System.out.println("successfully checked the contacts label");
	}
	
	@Test(priority=2)
	public void selectContact() throws InterruptedException
	{
		contactsPage.checkInBox("uma padma");
		contactsPage.checkInBox("abc abc");
		System.out.println("successfully checked the contact");
		Thread.sleep(1000);
		
	}
	
	@DataProvider
	public Object[][] getCRMContactsData() throws IOException
	{
		Object data[][]=TestUtil.getCRMExcelSheetData("contacts");
		return data;
	}
	
	@Test(priority=1, dataProvider="getCRMContactsData")
	public void verifyAddContactDetails(String fname,String lname, String email) throws InterruptedException
	{
		contactsPage.addNewContact(fname,lname,email);
		Thread.sleep(2000);
		System.out.println("successfully added new contact");
	}
	
	  @AfterMethod 
	  public void tearDown() { 
		  driver.quit(); 
		  }
	 
}
