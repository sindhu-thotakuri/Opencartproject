package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.Baseclass;

public class Myaccountpage extends Basepage {

	public Myaccountpage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[contains(normalize-space(),'My Account')]")
	WebElement myaccount_msgheadng;
	
	
	
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]")
	WebElement logout;
	
	public boolean setMyaccountexists() {
		try {
		return (myaccount_msgheadng.isDisplayed());
	   }catch(Exception e) {
		   return(false);
	   }
	}
		public void logOut() {
			logout.click();
	
	}

	
	
}
