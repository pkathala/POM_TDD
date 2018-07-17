package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewContactPage extends TestBase{
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//table[2]//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String t, String fname, String lname, String comp)
	{
		Select s=new Select(title);
		s.selectByVisibleText(t);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(comp);
		saveBtn.click();
		
	}

}
