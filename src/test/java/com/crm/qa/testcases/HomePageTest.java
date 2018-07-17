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


public class HomePageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	
	public HomePageTest() {
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
	}
	
	@Test(priority=1)
	public void homePageTitleTest()
	{
		Assert.assertEquals(hp.getPageTitle(), "CRMPRO");
	}
	
	@Test(priority=2)
	public void userLabelTest()
	{
		
		Assert.assertTrue(hp.chkPresenceUserLabel());
	}
	
	@Test(priority=3)
	public void navigateToContactsPageTest()
	{
		
		cp=hp.clickContactsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
