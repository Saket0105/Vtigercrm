package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {

	//Indentify create  organization 
	@FindBy(xpath ="//img[@alt='Create Organization...']")
	  public WebElement organization;

	public WebElement getOrganization() {
		return organization;
	}
	public Organizations(WebDriver driver) {
		  PageFactory.initElements(driver, this);
	}
	//create a method
	public void organizations() {
		 //click on create orgnaization
		organization.click();
	}
}
