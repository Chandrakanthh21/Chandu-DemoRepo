package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.utility.TestUtil;

public class TestBase 
{
	 public static WebDriver driver;  
	 public static Properties prop; 
	 
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream file = new FileInputStream("E:\\Selenium_Workspace\\Selenium_Maven_Project\\FreeCrmMavenProject1\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(file);	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static WebDriver initialization()
	{
		String browsername = prop.getProperty("Browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
				{
			      System.setProperty("webdriver.chrome.driver", "E:\\Selenium_6-3-2017\\chromedriver_win32\\chromedriver.exe");
			      driver = new ChromeDriver();
			      return driver;
				}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
		      System.setProperty("webdriver.gecko.driver", "E:\\Selenium_6-3-2017\\geckodriver-v0.14.0-win64\\geckodriver.exe");
		      driver = new FirefoxDriver();
		      System.out.println("test");
			} 
		else if(browsername.equals("InternetExplorer"))
		{
			System.setProperty("webdriver.IE.driver", "E:\\Selenium_6-3-2017\\IEDriverServer_x64_3.4.0.IEDriverServer.exe");
			driver = new InternetExplorerDriver();
 		}
		
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		System.out.println("test 1");
		return driver;
	}
	
	public static void frames(String text)
	{
		driver.switchTo().frame(text);
		
	}
	
	
	

}
