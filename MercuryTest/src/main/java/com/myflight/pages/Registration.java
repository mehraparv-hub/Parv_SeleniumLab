package com.myflight.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myflight.base.base;

public class Registration extends base {
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement continueRegBtn;
	
    @FindBy(xpath="//a[contains(text(),'Register')]")
    WebElement registerLink;
    
    @FindBy(xpath="//fieldset[@id='account']/legend[1]")
    WebElement sectionLbl;
    
    
    @FindBy(xpath="//input[@name='firstname']")
    WebElement firstname;
    @FindBy(xpath="//input[@name='lastname']")
    WebElement lastname;
    
    @FindBy(xpath="//input[@name='email']")
    WebElement email_id;
    
    @FindBy(xpath="//input[@name='telephone']")
    WebElement telephone;
    
    @FindBy(xpath="//input[@name='password']")
    WebElement password;
    
    @FindBy(xpath="//input[@name='confirm']")
    WebElement confirm_pwd;
    
    @FindBy(xpath="//input[@name='agree']")
    WebElement agreechckbox;
     
    @FindBy(xpath="//input[@class='btn btn-primary']")
    WebElement continuereg;
	
 public	Registration()
	{
		PageFactory.initElements(driver, this);
		
	}

 public void validateRegpage()
 {
	 
	 continueRegBtn.click();
 }
 
 public void validateregistration(String fname, String lname, String email, String phone, String pwd, String confirm)
 {
	
	 firstname.sendKeys(fname);
	 lastname.sendKeys(lname);
	 email_id.sendKeys(email);
	 telephone.sendKeys(phone);
	 password.sendKeys(pwd);
	 confirm_pwd.sendKeys(confirm);
	 agreechckbox.click(); 
	 continuereg.click();
	 
 }
 
 
}
