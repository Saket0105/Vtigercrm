package CommonUtil;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
	

public void maximize(WebDriver driver) {
	 driver.manage().window().maximize();	
}
 public void implictwait(WebDriver driver) {
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
} 
	
public void handledropdown(WebElement element,String targetedelement) {
	Select s=new Select(element);
	s.selectByVisibleText(targetedelement);
}
public void mouseHover(WebDriver driver,WebElement element) {
	Actions  a=new Actions(driver);
	a.moveToElement(element);
	a.perform();
}
public void switchwindow(WebDriver driver,String childurl) {
	Set<String> ids = driver.getWindowHandles();
	 
	   
	   for(String a : ids) {
			 String url = driver.switchTo().window(a).getCurrentUrl();
			 
			 
			 
			 if(url.contains(childurl)) {
				 break;
			 }
			 
		 }
	   
	  
	   
	   
}
public File screenShot(WebDriver driver,String ScreenshotName) throws IOException {
	TakesScreenshot ts= (TakesScreenshot) driver;
	File tempFile=ts.getScreenshotAs(OutputType.FILE);
	File destinationFile= new File("./Screenshot/"+ScreenshotName+".png") ;
	FileUtils.copyFile(tempFile, destinationFile);
	return destinationFile;
	
}
} 
