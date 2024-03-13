package POM;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtil.WebDriverUtil;

public class OrganizationInformationPage  {
	 WebDriverUtil wutil=new  WebDriverUtil();
	
	
	@FindBy(name="accountname")
public WebElement organizationnametf;

public WebElement getOrganizationnametf() {
	return organizationnametf;
}
@FindBy(xpath="(//input[@name='assigntype'])[2]")
private WebElement groupbtn;

public WebElement getGroupbtn() {
	return groupbtn;
}	
	
	@FindBy(name="assigned_group_id")
	private WebElement dropdown;

	public WebElement getDropdown() {
		return dropdown;
	}

	// Identify the save button
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement save;

	public WebElement getSave() {
		return save;
	}
	public OrganizationInformationPage(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
	}
	//create a method
	public void orgaanizationinformation(String orgname,String Groupdata) {
		//enter otganization name
		organizationnametf.sendKeys(orgname);
		 //click on group radio button
		 groupbtn.click();
		 //select Support group in the dropdown
		wutil.handledropdown(dropdown, Groupdata);
		//click on save button
		 save.click();
	}
}
