package qaclickacademy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import Resources.readConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	readConfig rc=new readConfig();
	String username=rc.getUsername();
	String password=rc.getPassword();
	String baseURL=rc.getbaseURL();
	public Logger log;
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		log=LogManager.getLogger("EBanking");
		//PropertyConfigurator.configure("Log4j.properties");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			System.out.println("chrome driver executed");
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
			System.out.println("Edge driver executed");
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
			System.out.println("chrome driver executed");
		}
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
