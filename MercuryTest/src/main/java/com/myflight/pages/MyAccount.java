package com.myflight.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myflight.base.base;

public class MyAccount extends base  {

	@FindBy(xpath="//h2[contains(text(),'My Orders')]")
	WebElement MyOrders;
	
	@FindBy(xpath="//a[contains(text(),'Tablets')]")
	WebElement tabletlink;
	
	@FindBy(xpath="//a[contains(text(),'Software')]")
	WebElement Softwarelink;
	
	@FindBy(xpath="//a[contains(text(),'Phones & PDAs')]")
	WebElement phonePDAlink;
	
	@FindBy(xpath="//*[@id='content']/ul[2]/li[1]/a")
	WebElement Orderhistorylink;
	
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement CartTotal;
	
	
	public MyAccount()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions & feature
	
	public String validateAccountPageTitle()
	{
		
		String title= driver.getTitle();
		
		return title;
		
	}
	
	public String validateAccountPageUrl()
	{
		
		String URL = driver.getCurrentUrl();
		
		return URL;
		
	}
	
	
	public Tablets validatetabletLink() throws FileNotFoundException
	{
		
		tabletlink.click();
		
	return new Tablets();
		
	}
	
	public Software validateSoftwarelink() throws FileNotFoundException
	{
		Softwarelink.click();
		return new Software();
		
	}
	

		public String validatecartTotal()
		{
			
			String Cart_total= CartTotal.getText();
			
			return Cart_total;
			
			
		}
		
public OrderHistory validateOrderhistorylink()
{
	
	Orderhistorylink.click();
	return new OrderHistory();
}
		
		
	

}
