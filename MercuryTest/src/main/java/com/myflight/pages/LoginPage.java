package com.myflight.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myflight.base.base;

public class LoginPage extends base {

	
	@FindBy (name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement loginBtn;
	
	@FindBy(xpath="//h2[contains(text(), 'Returning Customer')]")
	WebElement loginlabel;
	
	@FindBy(xpath="//a[contains(text(), 'Forgotten Password')]")
	WebElement forgetlink;
	
	
	@FindBy (xpath="//h2[contains(text(),'My Account')]")
	WebElement AfterLoginText;
	
	
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);
	}
		
	
	
	public String validatePageTitle()
	{
		
	String title	=driver.getTitle();
		
		return (title);
		
	}
	
	public String validateLoginLabel()
	{
		String label= loginlabel.getText();
		
		return(label);
	}		
		
	
	public MyAccount validatelogin(String mail, String pwd) throws InterruptedException, FileNotFoundException
	{
	
		email.sendKeys(mail);
		password.sendKeys(pwd);
		loginBtn.click();
		Thread.sleep(2000L);
		
		
		if(AfterLoginText.isDisplayed())
		{
			System.out.println("Login Sucessfull");
			
		}
		else
		{
			System.out.println("Login failed");
		}
		return new MyAccount();
	}
	
	
		
	
		
	}


