package CommonUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesfileUtil {

	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("src\\test\\resources\\loginCredentials.properties");
		Properties p=new Properties();
		p.load(file);
		String value = p.getProperty(key);
		
		return value;
	}
}
