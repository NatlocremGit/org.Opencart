package testCases;

import testBase.BaseClass;  
import pageObjects.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;


public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups = {"Regression", "Master"})
	public void test_account_Registration() throws InterruptedException
	{
        logging.debug("application logs.............");
		logging.info("*****   Starting TC_001_AccountRegistrationTest   *****");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.ActRegClick();
		hp.clickRegister();
		//hp.LogInClk();
		logging.info("*** HomePage Finished ***");
		
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		//regpage.LogInEmail("nat_raj84@yahoo.co.in");
		
		//regpage.LogInPassword("Monat@29");
		
		//regpage.LogInClk();
		
		//regpage.setFirstName("NATARAJAN");
		regpage.setFirstName(randomeString().toUpperCase());
		
		//regpage.setLastName("P");
		regpage.setLastName(randomeString().toUpperCase());

		
		Thread.sleep(3000);
		//regpage.setEmail("nat_raj84@yahoo.co.in");// randomly generated the email
		regpage.setEmail(randomeString()+"@gmail.com"); 
		logging.info("*** Mail Id Generated ***");
		
		Thread.sleep(3000);		
		
		//regpage.setPassword("Monat@29");
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		logging.info("*** Password Generated ***");
		
		
		Thread.sleep(3000);
		regpage.setPrivacyPolicy();
		
		Thread.sleep(3000);
		regpage.clickContinue();
		logging.info("*** Clicked on Registration Page Continue Button ***");
		
		
		logging.info("*** Registration Page Completed***");
		
		String confmsg=regpage.getConfirmationMsg();
		
		//System.out.println("This is ConfMsg: "+confmsg);
		logging.info("*** Confirmation Message Displayed ***");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Test FAILED");
	}
	catch(Exception e)
	{
		logging.error("test failed");
		//System.out.println("Test is Passed");
		Assert.fail();
	}
		logging.info("****** Finished TC_001_AccountRegistrationTest *******");
}
}
