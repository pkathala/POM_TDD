package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage lp;
	ContactsPage cp;
	HomePage hp;
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialize();
		lp=new LoginPage();
		cp=new ContactsPage();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame();
		cp=hp.clickContactsLink();
	}
	
	@Test(priority=1)
	public void contactsLabelTest()
	{
		Assert.assertTrue(cp.chkPresenceContactsLabel());
	}
	
	@Test(priority=2)
	public void selectSingleContactTest() throws InterruptedException
	{
		boolean flag;
		cp.selectContactByName("Jacob Goodwill");
		Thread.sleep(3000);
		if(cp.contactInput.isSelected())
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void selectMultipleContactTest() throws InterruptedException
	{
		boolean flag;
		cp.selectContactByName("Jacob Goodwill");
		Thread.sleep(3000);
		if(cp.contactInput.isSelected())
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		
		cp.selectContactByName("Rishi Huver");
		Thread.sleep(3000);
		if(cp.contactInput.isSelected())
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		Assert.assertTrue(flag);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
