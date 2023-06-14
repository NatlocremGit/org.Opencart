package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest extends BaseClass{
	@Test(groups = {"Sanity", "Master"})
	public void test_Login()
	{
		logging.info("Starting TC_002_LoginTest");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			
			hp.ActRegClick();
						
			hp.LogInClk();
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(rb.getString("email")); // valid email, get it from properties file
			
			lp.setPassword(rb.getString("password")); // valid password, get it from properties file
			
			
			Thread.sleep(3000);	
			lp.clickLogin();
			
			MyAccountPage macc=new MyAccountPage(driver);
			
			boolean targetpage=macc.isMyAccountPageExists();
						
			Assert.assertEquals(targetpage, true);
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logging.info(" Finished TC_002_LoginTest");
		
	}


}
