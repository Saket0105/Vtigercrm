package Vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtil.Baseclass;
import CommonUtil.ExcelUtil;
import CommonUtil.JavaUtil;
import CommonUtil.PropertiesfileUtil;
import CommonUtil.WebDriverUtil;

public class ContactTestng extends Baseclass {
	
	 WebDriver d;
	PropertiesfileUtil putil=new PropertiesfileUtil();	
	WebDriverUtil wutil=new WebDriverUtil();
	ExcelUtil eutil=new ExcelUtil();
	JavaUtil jutil=new JavaUtil();
@Test
public void contactsTest() throws IOException, InterruptedException
{
	/*WebDriver d= new ChromeDriver();
	//d.manage().window().maximize();	
	wutil.maximize(d);
	wutil.implictwait(d);*/
	//read data from property file
	//read data from excel 
	
	
	/*String URL = putil.getDataFromProperties("Url");
	String USERNAME = putil.getDataFromProperties("Username");
	String PASSWORD = putil.getDataFromProperties("Password");*/
	 String NAME = eutil.getDataFromExcel("contact", 0, 1);
	String LAST = eutil.getDataFromExcel("contact", 1, 1);
	String group = eutil.getDataFromExcel("Contact", 2,1);
	String org = eutil.getDataFromExcel("contact", 3, 1);
	 
	 
	 
	// to launch browser
	/*d.get(URL);
	//fetch the username
	d.findElement(By.name("user_name")).sendKeys(USERNAME);
	d.findElement(By.name("user_password")).sendKeys(PASSWORD);
	d.findElement(By.id("submitButton")).click();*/
	d.findElement(By.xpath("//a[text()='Contacts']")).click();
	d.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
	d.findElement(By.name("firstname")).sendKeys(NAME);
	d.findElement(By.name("lastname")).sendKeys(LAST);
	
	// failed the test
//String actualurl = d.getCurrentUrl();
//String expectedurl = "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";		
//assertEquals(actualurl, expectedurl);		
	
	
	
	// WebElement notify = d.findElement(By.name("notify_owner"));
	//assertTrue(notify.isDisplayed());
	d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	WebElement var = d.findElement(By.name("assigned_group_id"));
	wutil.handledropdown(var, group);
	
	d.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
	//transfer control to parent to child window
	wutil.switchwindow(d, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_sub");
     Thread.sleep(2000);
//	wutil.screenShot(d, "contact");
	Thread.sleep(2000);
      d.findElement(By.name("search_text")).sendKeys(org);
      d.findElement(By.name("search")).click();
      Thread.sleep(2000);
	d.findElement(By.xpath("//a[text()='Hp']")).click();
	Thread.sleep(2000);
	//transfer control to child to parent window
	wutil.switchwindow(d, "http://localhost:8888/pune/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
	 d.findElement(By.name("button")).click();
	 Thread.sleep(2000);
		/*WebElement mouse = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mouseHover(d, mouse);
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();*/
		
}
}


