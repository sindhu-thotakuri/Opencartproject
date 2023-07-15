package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Accountregistrationpage;
import pageObjects.Basepage;
import pageObjects.Homepage;
import testBase.Baseclass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC_001_AccountRegistrationTest extends Baseclass {
	
	//Note:this application is restricted for Submit button is do through automation because 
	@Test(groups= {"regression", "master"})
	public void test_account_Registration() throws InterruptedException
	{
		//logger.debug("Application logs");
		logger.info("*** TC_001_AccountRegistrationTest ***");
		
		try {
	
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		logger.info(" clicked on MyAccount");
		hp.clickRegister();
		logger.info(" clicked on register");
		Accountregistrationpage regpage=new Accountregistrationpage(driver);
		logger.info("providing customer data");
		
		regpage.setFirstName(randomString().toUpperCase());
		
		regpage.setLastName(randomString().toUpperCase());
		
		regpage.setEmail(randomString()+"@gmail.com");// randomly generated the email
		
		
		String password=randomAlphanumberic();
		regpage.setPassword(password);
		Thread.sleep(3000);
		regpage.setPrivacyPolicy();
		
		
		regpage.clickContinue();
		logger.info("clicked on continue");
		
		String confmsg=regpage.getConfirmationMsg();
		logger.info("validating expected message");
		
	//Assert .assertEquals(confmsg,"Your Account Has Been Created!","Not getting expected message");
	
		}catch(Exception e) {
			logger.error("test failed");//error log
			Assert.fail();
		}
		logger.info("*** Finished TC_001_AccountRegistrationTest ***");
	}
	
}
