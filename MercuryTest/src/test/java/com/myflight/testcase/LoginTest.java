
//Changing comment for Git commit new trest//

package com.myflight.testcase;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myflight.base.base;
import com.myflight.pages.LoginPage;
import com.myflight.pages.MyAccount;

public class LoginTest extends base {
	LoginPage log;
	MyAccount myaccount;
	
	
	public LoginTest()
	{
		
		super();
		
	}

	@BeforeMethod
	
	public void setup() throws Exception
	{
	  initialize();
	  log =  new LoginPage();
	  
	  
	}
	
	@Test(priority=1)
	
	public void verifyLoginPagetitleTest()
	
	{
		
		String title = log.validatePageTitle();
		
		Assert.assertEquals(title, "Account Login");
		
	}
	@Test(priority=2)
	public void verifyLoginLableTest()
	
	{
		
	String label= log.validateLoginLabel();
		
		Assert.assertTrue(label.contains("Returning Customer"));
		
	}
	
	@Test(priority=3)
	public void verifyLogintest() throws Exception
	{
		myaccount = log.validatelogin(prop.getProperty("email"), prop.getProperty("password"));
		
		
		Thread.sleep(2000L);
		
	}
	

@AfterMethod

public void teardown()
{
	driver.quit();	
	
}


}
