package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties prop;

	public ConfigReader()
	{
	prop = new Properties();
	FileInputStream fis;
	try {
		fis = new FileInputStream("src\\test\\resources\\Config.properties");
		prop.load(fis);
	} catch (FileNotFoundException e ) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public String getUrl()
	{
		return prop.getProperty("URL");
	}
	
	public String getUsername()
	{
		return prop.getProperty("username");
	}
	
	public String getPassword()
	{
		return prop.getProperty("password");
	}
	
}
