package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		try
		{
	          prop=new Properties();
	          FileInputStream fis=new FileInputStream("C:\\Eclipse\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
	          prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
    public static void initialization()
    {
    	String browsername=prop.getProperty("browser");
    	if(browsername.equals("chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
    		driver=new ChromeDriver();
    		
    	}
    	else if(browsername.equals("FF"))
       {
    		System.setProperty("webdriver.gecko.driver", "C:\\browsers\\geckodriver.exe");
    		driver=new FirefoxDriver();
       }
    	e_driver=new EventFiringWebDriver(driver);
    	eventListener=new WebEventListener();
    	e_driver.register(eventListener);
    	driver=e_driver;
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
    	driver.get(prop.getProperty("url"));
     }
}
