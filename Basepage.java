package BasePom;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtil.ExcelUtil;
import CommonUtil.JavaUtil;
import CommonUtil.PropertiesfileUtil;
import CommonUtil.WebDriverUtil;
import POM.Hompage;
import POM.Loginpage;
import POM.OrganizationInformationPage;
import POM.Organizations;

public class Basepage {
	public static WebDriver driver;
public static void main(String[] args) throws InterruptedException, IOException {
	
	
	PropertiesfileUtil putil= new PropertiesfileUtil();
	ExcelUtil eutil=new ExcelUtil();
	WebDriverUtil wutil= new WebDriverUtil();
	JavaUtil jutil=new JavaUtil();
	
	//TO REad  data from property file
	String Browser = putil.getDataFromProperties("Browser");
	String USERNAME = putil.getDataFromProperties("Username");
	String PASSWORD = putil.getDataFromProperties("Password");
	String URL = putil.getDataFromProperties("Url");
	
	
	//to read data from excel file
	 String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
	 String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);
	
	//TO launch the browser
	if (Browser.equals("Chrome")) {
		driver=new ChromeDriver();
	}else if (Browser.equals("Firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		driver=new EdgeDriver();
	}
	
	//ChromeDriver driver= new ChromeDriver();
	//To maximize browser window
	driver.manage().window().maximize();
	
	//TO launch the application
	driver.get(URL);
	
	//create object of login page
	Loginpage lp=new Loginpage(driver);
	lp.Login(USERNAME, PASSWORD);
	
	//create object home page
     Hompage hp= new Hompage(driver);
    hp.Home();
     //create  object of organizatioinformationpage
     Thread.sleep(2000);
     Organizations o =new Organizations(driver);
     //click on create orgnaization
     o.organizations();
     
     //create object of organization information  page
    OrganizationInformationPage oip= new  OrganizationInformationPage(driver);
     //enter otganization name
    oip.orgaanizationinformation(ORGNAME+jutil.getRandomNumber(), GROUP);    
    
     Thread.sleep(2000);
     hp.Home(driver);
     //mouserhover on the image
   //  WebElement mouse = hp.getImage();
    // wutil.mouseHover(driver, mouse);
     
     //click on signout button
     /*hp.getSingout().click();*/
     
     
} 
}





