package Vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtil.ExcelUtil;
import CommonUtil.JavaUtil;
import CommonUtil.PropertiesfileUtil;
import CommonUtil.WebDriverUtil;



//create object of the common util
public class Leads {
	PropertiesfileUtil putil=new PropertiesfileUtil();	
	WebDriverUtil wutil=new WebDriverUtil();
	ExcelUtil eutil=new ExcelUtil();
	JavaUtil jutil=new JavaUtil();
	
	
	
	@Test
	public void leadsTest() throws IOException, InterruptedException
	{
		//create object of the browser
		WebDriver d= new ChromeDriver();
		//using the object variable and the method
		wutil.maximize(d);
		//using the object variable and the method
		wutil.implictwait(d);
		
		
		//read the data from the property file
		String URL = putil.getDataFromProperties("Url");
		String USERNAME = putil.getDataFromProperties("Username");
		String PASSWORD = putil.getDataFromProperties("Password");
		
		//read the data from the Excel file 
		String FIRST = eutil.getDataFromExcel("Lead", 0, 1);
		String LAST = eutil.getDataFromExcel("Lead", 1, 1);
		 String Orgname = eutil.getDataFromExcel("Lead", 2, 1);
		 String Drop = eutil.getDataFromExcel("Lead", 3, 1);
		
		//launch the browser
		d.get(URL);
		//Enter the username with the help properties  file variables
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		
		//Enter the passsword with the help properties  file variables
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
		//click the login button to login the website
		d.findElement(By.id("submitButton")).click();
		
		//click the lead button 
		d.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		
		//select the plus button  to add the leads in the database
		d.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Enter the first name with the help property file variable
		d.findElement(By.name("firstname")).sendKeys(FIRST);
		
		//Enter the last name with the help property file variable
		d.findElement(By.name("lastname")).sendKeys(LAST);
		
		//Enter the organizations name with the help property file variable
		d.findElement(By.name("company")).sendKeys(Orgname);
		
		//click on the radio button from the selection
         d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
         
         
         //click on the dropdown  and select the option 
         WebElement dropdown = d.findElement(By.name("assigned_group_id"));
         wutil.handledropdown(dropdown, Drop );
		
         //click on the save button 
         d.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
         Thread.sleep(2000);
         //mouse hovering the img 
     	WebElement mouse = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
     	wutil.mouseHover(d, mouse);
     	
     	//click the signout from  signout to the website
     	d.findElement(By.xpath("//a[text()='Sign Out']")).click();
     	d.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		
	}
	
	
	
	
}
