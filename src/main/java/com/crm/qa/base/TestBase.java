package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utils.Utility;
import com.crm.qa.utils.WebEventListener;

public class TestBase {
	 public static Properties prop;
	 public static WebDriver driver;
	 public static EventFiringWebDriver edriver;
	 public static WebEventListener eventlistener;

	
	public TestBase(){
		
		try{
			File src = new File("C:\\sivareddyproject\\framework\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
	}
	public static void initialization(){
		String browsername = prop.getProperty("browser") ;
		if(browsername.equalsIgnoreCase("chrome")){
		   

	 System.setProperty("webdriver.chrome.driver","C:\\Users\\Sudhakar\\Desktop\\automation\\"
					+ "selenium_java\\src\\selenium_java\\chromedriver.exe");
		driver = new ChromeDriver();
	}else if (browsername.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Sudhakar\\Desktop\\selenium\\00_seleniumfiles\\2_Selenium softwares\\64Bit_Selenium Files\\EclipseJDK64bit\\EclipseWindows-64bit\\eclipse\\New folder\\New folder\\geckodriver.exe");
	 driver=new FirefoxDriver();
	}
		edriver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		edriver.register(eventlistener);
		driver = edriver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
