package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testBase.Baseclass;

public class TC002_logintest extends Baseclass {
	
	
	@Test(groups= {"sanity", "master"})
	public void logIn() {
		
		try {
		logger.info("Login Test");
		
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account");
		hp.clickLogin();
		logger.info("clicked on login");
		
		Loginpage lp=new Loginpage(driver);
		lp.setEmalid(rb.getString("email"));//getting email from properties file
		lp.setPassword(rb.getString("password"));
		logger.info("entered emial and passwod");
		lp.loginButton();
		
		Myaccountpage macc=new Myaccountpage(driver);
		boolean targetpage=macc.setMyaccountexists();
		//Assert.assertEquals(targetpage, true);
		//macc.logOut();
	    }
		catch(Exception e) {
		Assert.fail();
		}
		
	   logger.info("** Finshed TC002_logintest **");
	   
	  
	}
	

}
