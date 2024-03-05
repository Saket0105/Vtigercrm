package CommonUtil;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Baseclass {
  public WebDriver d= new ChromeDriver();	
	
	WebDriverUtil wutil=new WebDriverUtil();
	PropertiesfileUtil putil=new PropertiesfileUtil();
	
@BeforeSuite
public void BS()
{
	 System.out.println("Connect to data base");
}
@BeforeClass
public void BC() throws IOException
{

	//Beforeclass is used to launch application
	String URL = putil.getDataFromProperties("Url");
	

	//d.manage().window().maximize();	
	wutil.maximize(d);
	wutil.implictwait(d);
	
	
	// to launch to the application
		d.get(URL);
}
@BeforeMethod
public void BM() throws IOException

//beforemethod is to login the application
{
	String USERNAME = putil.getDataFromProperties("Username");
	String PASSWORD = putil.getDataFromProperties("Password");
	
	//login to application
	d.findElement(By.name("user_name")).sendKeys(USERNAME);
	d.findElement(By.name("user_password")).sendKeys(PASSWORD);
	d.findElement(By.id("submitButton")).click();
	
}
@AfterClass
public void AC()
//@afterclass is used to close the browser
{
	d.quit();
}
@AfterSuite
public void AS()
{
	System.out.println("Disconnect to data base");
}
@AfterMethod
public void AM() throws InterruptedException
{
	Thread.sleep(2000);
	//@afterclass is used for signout for the appplication
	WebElement mouse = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	wutil.mouseHover(d, mouse);
	d.findElement(By.xpath("//a[text()='Sign Out']")).click();
}
}
