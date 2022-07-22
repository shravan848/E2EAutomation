package qaclickacademy;

import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ExtentReportTest {
	ExtentReports extent;
	ExtentTest test;
	//ExtentLoggerReporter logger = new ExtentSparkReporter("user/build/name/");
       @Test
		public void configMethod()
		{
		extent = new ExtentReports();  
		/*---------Chrome Driver initialization--------*/
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		/*====Firefox driver initialization without geckodriver.exe===
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver(); */
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHRAVAN\\Documents\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		Capabilities cap=((RemoteWebDriver)driver).getCapabilities();
		String browserName= cap.getBrowserName();
		String browserVersion= cap.getBrowserVersion();
		System.out.println(browserName);
		System.out.println(browserVersion);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		System.out.println(System.getProperty("user.dir"));
	
	extent.createTest("Browser opened successfully").log(Status.PASS, "Browser executed done");
		
		/*System.out.println(java.time.LocalDate.now());
		String time=java.time.LocalDate.now().toString();
		
		String path=System.getProperty("user.dir")+"\\target\\"+time+"report";
		System.out.println(path);*/
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");  
    Date date = new Date(); 
    String time=formatter.format(date);
    System.out.println(time);
    
    /*----------Extent reports with date and time append--------*/
    	//String path=System.getProperty("user.dir")+"\\target\\report"+time;
		//ExtentSparkReporter report =new ExtentSparkReporter(path+".html");
		
		ExtentSparkReporter report =new ExtentSparkReporter(System.getProperty("user.dir")+"\\target\\index\\Spark"+time+".html");
		
		report.config().setDocumentTitle("Test Results");
		report.config().setReportName("Web Automation Results");			
		extent.attachReporter(report);
		String os=System.getProperty("os.name");
		extent.createTest("Initial Demo").log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		extent.setSystemInfo("Tester", "Shravan V");
		extent.setSystemInfo("OS", os);
		
		//extent.setSystemInfo("Browser & Version", browserName+ browserVersion );
		driver.close();
		extent.flush();
	}
	/*@Test
	public void initialDemo()
	{
		//ExtentTest test = extent.createTest("Initial demo");
		extent.createTest("Initial Demo").log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHRAVAN\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//extent.createTest("Initial Demo").pass("Successfully landed on browser");
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		
		//extent.createTest("Browser opened successfully");
		//Log.info("executed done");
		driver.close();
		
		System.out.println("done");
		//Assert.assertEquals(driver.getTitle(), "Shravan");
		//test1.fail("Result donot match");
		extent.flush();
		
		
		
	}*/
	

}
