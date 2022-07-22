package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

@Test
public class readConfig {

	Properties prop;
	File src=new File("C:\\Users\\SHRAVAN\\eclipse-workspace\\New\\Mavenjava\\src\\test\\java\\Resources\\Config.properties");
	{
	try { 
		FileInputStream fis=new FileInputStream(src);
		prop=new Properties();
		prop.load(fis);
		
	}
	catch(Exception e)
	{
		System.out.println("Exception is :"+e.getMessage());
		}
	}
		public String getbaseURL()
	{
		String url=prop.getProperty("baseURL");
		return url;
	}
		public String getUsername()
		{
			String username=prop.getProperty("username");
			return username;
		}
		public String getPassword()
		{
			String password=prop.getProperty("password");
			return password;
		}		
		
}

