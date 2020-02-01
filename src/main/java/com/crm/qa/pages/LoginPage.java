package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement singupbutton;
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement homepagelogo;
	
	@FindBy(xpath="//title[contains(text(),'Free CRM in the cloud software boosts sales')]")
	WebElement crmtitle;
	
	
	/*public LoginPage()
	{
		PageFactory.initElements(driver, LoginPage.class);
	}*/
	
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateCrmLogo()
	{
		return homepagelogo.isDisplayed();
	}
	
	public void Login(String un, String pass)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		username.sendKeys(un);
		password.sendKeys(pass);
		loginbutton.click();
		
		//return new HomePage();
	}
	
}
