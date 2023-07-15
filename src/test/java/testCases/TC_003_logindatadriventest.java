package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testBase.Baseclass;
import utilities.Dataprovider;

public class TC_003_logindatadriventest extends Baseclass{

	@Test(dataProvider="LoginData" , dataProviderClass=Dataprovider.class)//we seperated data provider class so we have mentioned dataProviderClass
	void test_loginDDT(String email , String password, String Expected) {
		
		logger.info("***Starting the TC_003_logindatadriventest *** ");
		try{
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account");
		hp.clickLogin();
		logger.info("clicked on login");
		
		Loginpage lp=new Loginpage(driver);
		lp.setEmalid(email);//getting email from properties file
		lp.setPassword(password);
		logger.info("entered emial and passwod");
		lp.loginButton();
		
		Myaccountpage macc=new Myaccountpage(driver);
		boolean targetpage=macc.setMyaccountexists();
		
		if(Expected.equals("Valid")) {
			if(targetpage==true) {
				macc.logOut();
				Assert.assertTrue(true);
			}
			else {
				macc.logOut();
				Assert.assertTrue(false);
			}
				
			}
		
		if(Expected.equals("Invalid")) {
			if(targetpage==true) {
				macc.logOut();
				Assert.assertTrue(false);
			}
			else {
				
				Assert.assertTrue(true);
			}
		}
	}
		
		catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("** Finished TC003 **");
	
	}
}
