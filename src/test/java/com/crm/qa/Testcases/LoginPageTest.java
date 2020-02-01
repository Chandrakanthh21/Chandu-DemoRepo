package com.crm.qa.Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	
	
	public LoginPageTest()
	{
		super();
		
	}
	
	@Test
	public void Test()
	{
		System.out.println("welcome");
		initialization();
		System.out.println("After initialization");
		loginpage= PageFactory.initElements(driver, LoginPage.class);
		homepage = PageFactory.initElements(driver, HomePage.class);
	}
	
    @Test(priority=1)
    public void loginpageTitleTest()
    {
    	String title = loginpage.ValidateLoginPageTitle();
    	System.out.println(title);
    	Assert.assertEquals(title, "Free CRM in the cloud software boosts sales");
    	
    }
    
    @Test(priority=2)
    public void CRMloginpageimage()
    {
    	boolean flag = loginpage.ValidateCrmLogo();
    	System.out.println(flag);
    	Assert.assertTrue(flag);
    }
	
    @Test(priority=3)
    public void logintest()
    {
       loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
    }
    
    @Test(priority=4)
    public void ClickonCompany()
    {
    	//homepage.verifyhomepage();
    	
    	homepage.Company();
    	
    }
	/*@AfterMethod
	public void TearDown()
	{
    	driver.quit();
	}*/
}

