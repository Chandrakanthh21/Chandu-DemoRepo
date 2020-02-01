package com.crm.qa.pages;

import junit.framework.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase 
{
	@FindBy(xpath="//td[text()='CRMPRO']")
	WebElement CRMPRO_Text;
	
	@FindBy(xpath="//a[@title='Companies']")
	WebElement CompanyLink;
	
	public void verifyhomepage()
	{
		System.out.println(CRMPRO_Text.isDisplayed());
		
	}
	public void Company()
	{
		System.out.println("Before frame");
		TestBase.frames("processFrame");
		//driver.switchTo().frame("processFrame");
		System.out.println("After frame	");
		CompanyLink.click();
	}

}
