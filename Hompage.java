package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtil.WebDriverUtil;

public class Hompage extends WebDriverUtil{
	//Identify organization 
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement organization;
		
	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getConatct() {
		return conatct;
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getSingout() {
		return singout;
	}

	//identify contact
	@FindBy(xpath="(//a[text()='Contacts'])[1]")
	private WebElement conatct;
	
	//Identify image
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement image;
	
	//Identify sing out  
	@FindBy(xpath="//a[text()='Sign Out']")
    private	WebElement singout;
	
	public Hompage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	   
	public void Home() {
		organization.click();
		
	}
	public void Home(WebDriver driver)
	{
		//mouserhover on the image
				mouseHover(driver, image);
				 //click on signout button
				singout.click();
	}
}



