package com.myflight.testcase;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.myflight.base.base;
import com.myflight.pages.Registration;
import com.myflight.util.TestUtil;

public class RegistrationTest extends base{
	public static Registration reg;
	
	
	RegistrationTest()
	{
		super();
				
	}
	
	@BeforeMethod
	
	public void setup()
	{
		initialize();
		
		reg = new Registration();
		reg.validateRegpage();	
	}
	
	
	@DataProvider
	
	public Object[][] Regtestdata() throws IOException
	{
		Object data[][]= TestUtil.Excel_reader("Registration");
		
		return data;
		
	}
	
	
	@Test (dataProvider="Regtestdata")
	
	public void RegTest(String firstname, String lastname, String email, String phone, String password, String confirm) throws Exception

	{
		
	
	Thread.sleep(3000L);
		reg.validateregistration(firstname, lastname, email, phone, password, confirm);
		
		
 
	}
	 

@AfterMethod
public void teardown()
{
	
	driver.quit();
}
}