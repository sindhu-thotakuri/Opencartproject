package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

	public Homepage(WebDriver driver) {
		super(driver);//invoking parent class constructor //construtor name should be same as Classname
		
	}
	// Elements
		@FindBy(xpath = "//span[text()='My Account']")
		WebElement lnkMyaccount;

		@FindBy(linkText = "Register")
		WebElement lnkRegister;
		
		
		@FindBy(xpath="//a[contains(normalize-space(),'Login')]")
		WebElement login;

		// Action Methods
		public void clickMyAccount() {
			lnkMyaccount.click();
		}

		public void clickRegister() {
			lnkRegister.click();
		}
		public void clickLogin() {
			login.click();
		}


}
