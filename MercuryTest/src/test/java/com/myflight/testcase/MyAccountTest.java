package com.myflight.testcase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.myflight.base.base;
import com.myflight.pages.LoginPage;
import com.myflight.pages.MyAccount;
import com.myflight.pages.OrderHistory;
import com.myflight.pages.Software;
import com.myflight.pages.Tablets;

public class MyAccountTest extends base{
	
	MyAccount myaccount;
	LoginPage log;
	Software software;
	Tablets tablets;
	OrderHistory order;
	
	MyAccountTest(){
		
		super();
	}
	

	@BeforeMethod
	
	public void setup() throws Exception
	{
		
		initialize();
		
		myaccount =  new MyAccount();
		log = new LoginPage();
		software= new Software();
		tablets = new Tablets();
		order= new OrderHistory();
		myaccount= log.validatelogin(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1, enabled = true)
	public void validateAccountPageTitleTest()
	{
		
	String title=	myaccount.validateAccountPageTitle();
		
		System.out.println("My Account Page Title is" +title);
		
		
		
	}
	
	@Test(priority=2, enabled = true)
	public void validateAccountPageUrlTest()
	
	{
		
		String URL =myaccount.validateAccountPageUrl();
		
		System.out.println(URL);
		
	}
	
	@Test (priority=3, enabled = true)
	public void validatetabletLinkTest() throws Exception
	{
		
		tablets = myaccount.validatetabletLink();
		
		
	
	}
	
	@Test (priority=4, enabled = true)
	
	public void validateSoftwarelinkTest() throws Exception {
		
		
	software = myaccount.validateSoftwarelink();
	
	
	}
	@Test(priority=5)
	
	public void validateOrderhistorylinkTest() throws Exception {
		
		
		order= myaccount.validateOrderhistorylink();
		
	}
	
	@Test (priority=6, enabled = true)
	public void validatecartTotalTest() {
		
		
		
		String total= myaccount.validatecartTotal();
		
		System.out.println("Initial cart total is: " +total);
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
	
}	


