package com.crm.qa.pages;

import com.crm.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
	
	//PageFactory or OR
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement LgnBtn;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement EmailId;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpLnk;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * public void clickLoginBtn() { LgnBtn.click(); }
	 */
	public PersonalProfilePage Login(String un,String pwd)
	{
		EmailId.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();
		return new PersonalProfilePage();
	}
	
	

}
