package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	public WebElement contactInput;
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean chkPresenceContactsLabel()
	{ 
		return contactsLabel.isDisplayed();
		
	}
	
	public void selectContactByName(String name)
	{
		contactInput=	driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td//preceding-sibling::td//input"));
		contactInput.click();
	}
	
	public boolean chkPresenceOfContactName(String name)
	{
		boolean flag;
		if(driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).isDisplayed())
		{
			flag=true;
		}
		else
			flag=false;
		return flag;
	}
	
}
