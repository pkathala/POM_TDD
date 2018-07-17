package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	

	@FindBy(xpath="//td[contains(text(),'User: t c')]")
	WebElement userLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean chkPresenceUserLabel()
	{

		return userLabel.isDisplayed();
	}
	
	
	
	public ContactsPage clickContactsLink()
	{
		
		contactsLink.click();
		return new ContactsPage();
	}
	
	public NewContactPage clickNewContactLink()
	{
		Actions act=new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		return new NewContactPage();
	}
	
	public DealsPage clickDealsLink()
	{
		
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickTasksLink()
	{
		
		tasksLink.click();
		return new TasksPage();
	}
	
}
