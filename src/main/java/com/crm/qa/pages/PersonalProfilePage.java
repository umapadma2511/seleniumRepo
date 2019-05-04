package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class PersonalProfilePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'uma padma')]")
	WebElement displayedUsername;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement Contactslink;
	
	
	
	public PersonalProfilePage()
	{
		PageFactory.initElements(driver, this);
	}
	//actions on the page
	
	public String checkPageTitle()
	{
		return driver.getTitle();
	}
	
	public String loggedInUser()
	{
		return displayedUsername.getText();
	}
    
	public DealsPage clickOnDeals()
	{
		DealsLink.click();
		return new DealsPage();
	}
	public ContactsPage clickOnContacts()
	{
		Contactslink.click();
		return new ContactsPage();
	}
}
