package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	
	
	
	//Identify USername tf
	@FindBy(name="user_name")
	 private WebElement usernametf;
		public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	//identify password tf
	@FindBy(name="user_password")
	private WebElement passwordtf;
		
		//Identify LOgin button
	@FindBy(id="submitButton")
    private	WebElement loginbtn;
	
	//create a constructor
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		 
	}
	//create a method 
	public void Login(String usernamedata,String passworddata) {
		usernametf.sendKeys(usernamedata);
		 passwordtf.sendKeys(passworddata);
		 loginbtn.click();
	}
}

