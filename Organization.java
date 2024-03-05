package Vtiger;

import java.io.IOException;
import java.time.Duration;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtil.ExcelUtil;
import CommonUtil.JavaUtil;
import CommonUtil.LIstenerImplementation;
import CommonUtil.PropertiesfileUtil;
import CommonUtil.WebDriverUtil;

@Listeners(LIstenerImplementation.class)
public class Organization {
	PropertiesfileUtil putil=new PropertiesfileUtil();	
	WebDriverUtil wutil=new WebDriverUtil();
	ExcelUtil eutil=new ExcelUtil();
	JavaUtil jutil=new JavaUtil();
@Test
public void OrganizationsTest() throws IOException, InterruptedException
{
	WebDriver d= new ChromeDriver();
	//d.manage().window().maximize();	
	wutil.maximize(d);
	wutil.implictwait(d);
	//read data from property file
	//read data from excel 
	
	
	String URL = putil.getDataFromProperties("Url");
	String USERNAME = putil.getDataFromProperties("Username");
	String PASSWORD = putil.getDataFromProperties("Password");
	 String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
	String group = eutil.getDataFromExcel("Organizations", 1, 1);
	 
	 
	 
	 
	// to launch 
	d.get(URL);
	d.findElement(By.name("user_name")).sendKeys(USERNAME);
	d.findElement(By.name("user_password")).sendKeys(PASSWORD);
	d.findElement(By.id("submitButton")).click();
	
	d.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	d.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
	d.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
	//IN ASSINGED TO VLAUE
	d.findElement(By.cssSelector("input[value='T']")).click();
	//d.findElement(By.xpath("//option[text()='Support Group']")).click();
	WebElement var = d.findElement(By.name("assigned_group_id"));
	wutil.handledropdown(var, group);
	
	//
	d.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	Thread.sleep(2000);
	WebElement mouse = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	wutil.mouseHover(d, mouse);
	d.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
}
}
