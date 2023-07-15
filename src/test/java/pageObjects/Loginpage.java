package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage{

	public Loginpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(name="email")
	WebElement email_txt;
	
	@FindBy(name="password")
	WebElement password_txt;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement login_btn;
	
	public void setEmalid(String email) {
		email_txt.sendKeys(email);
	}
	public void setPassword(String password) {
		password_txt.sendKeys(password);
	}
	public void loginButton() {
		login_btn.click();
	}
}
