package com.myflight.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.myflight.util.TestUtil;

public class base {
	
	public static Properties prop;
	public static WebDriver driver;
	
	
	public base()
	{

		
		try {
			prop = new Properties();
			
FileInputStream fis = new FileInputStream("C:\\JavaProg\\MercuryTest\\src\\main\\java\\com\\myflight\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
		
		public static void initialize()
		{
			String browsername = prop.getProperty("browser");
			
			if (browsername.equals("chrome"))
			{
				
				System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
				
			 driver = new ChromeDriver();
			}
			
			 else if (browsername.equals("firefox")) {
				 
				System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
				driver = new FirefoxDriver();
				
				 
			 }	
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_PAGE_WAIT, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
				driver.get(prop.getProperty("url"));
				driver.manage().window().maximize();
				
			}
			
		}
		
		
	

	
	
	
	
	
	
