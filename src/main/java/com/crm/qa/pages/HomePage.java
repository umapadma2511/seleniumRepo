package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.pagefactory.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends TestBase {
	
	//PageFactory or OR
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement LgnBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SgnUpBtn;
	
	
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[2]/div")
	WebElement AppLogo;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateHomePageTitle()
	{
		return driver.getTitle();
	
	}
	
	public boolean validateLogo()
	{
		
		 return AppLogo.isDisplayed();
	}
   
	public LoginPage clickLogin()
	{
		LgnBtn.click();
		return new LoginPage();
	}
}
