package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.TestUtil;

public class NewContactPageTest extends TestBase {
	
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	NewContactPage ncp;
	String sheet="contacts";
	
	public NewContactPageTest() {
		super();
	}
	@DataProvider
	public Object[][] getNewContactData()
	{
		return TestUtil.getTestData(sheet);
		
	}
	@BeforeMethod
	public void setUp()
	{
		initialize();
		lp=new LoginPage();
		
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame();
		ncp=hp.clickNewContactLink();
	}
	
	@Test(priority=1, dataProvider="getNewContactData")
	public void createNewContactTest(String t, String fname, String lname, String comp)
	{
		ncp.createNewContact(t, fname, lname, comp);
		cp=hp.clickContactsLink();
		Assert.assertTrue(cp.chkPresenceOfContactName(fname+" "+lname));
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
