package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement ContactsLabel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement AddContactBtn;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div/div/div/div/div[1]/input")
	WebElement Email;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[6]/div[1]/div/div/div/div[1]")
	WebElement socialChnl;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[6]/div[1]/div/div/div/div[1]/div[2]/div[2]")
	WebElement SlctFacebook;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement SaveCtnct;
	/*
	 * @FindBy(
	 * xpath="//td[text()='uma padma']//parent::tr//parent::tbody//preceding-sibling::thead[@class='full-width']//parent::table[@class='ui celled sortable striped table custom-grid']"
	 * ) WebElement checkIntxtbox;
	 */
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkContactsLabel()
	{
		return ContactsLabel.isDisplayed();
	}
	
	public void checkInBox(String name)
	
	{
		driver.findElement(By.xpath("//td[text()='"+name+"']")).click();
		//driver.findElement(By.xpath("//td[text()='"+name+"']//parent::tr//parent::tbody//preceding-sibling::thead[@class='full-width']//parent::table[@class='ui celled sortable striped table custom-grid']")).click();
	}
	
	public void addNewContact(String fname,String lname,String email) throws InterruptedException
	{
		AddContactBtn.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		Email.sendKeys(email);
		SaveCtnct.click();
		
		
	}

}
