package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;

	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialize();
		lp=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		Assert.assertEquals(lp.getPageTitle(), "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority=2)
	public void crmLogoTest()
	{
		boolean b=lp.chkLogoPresence();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
