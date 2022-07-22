package qaclickacademy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {
	
	public static Logger logger=Logger.getLogger("Maven_Java");
	
	public  WebDriver driver;
	public Properties prop;
	
public WebDriver initializeDriver() throws IOException
{	
	//DOMConfigurator.configure("Log4j2.xml");
	PropertyConfigurator.configure("Log4j.xml");
    prop= new Properties();
    FileInputStream fis=new FileInputStream("C:\\Users\\SHRAVAN\\eclipse-workspace\\New\\Mavenjava\\src\\test\\java\\Resources\\data.properties");
 
 //PropertyConfigurator.configure("Log4j.xml");
prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHRAVAN\\eclipse-workspace\\New\\Mavenjava\\Drivers\\chromedriver.exe");
	driver= new ChromeDriver();
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("edge"))
{
//	IE code
}

//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}

}
