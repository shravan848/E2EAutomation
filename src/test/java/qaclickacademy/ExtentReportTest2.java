package qaclickacademy;

import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTest2 {
	ExtentReports extent = new ExtentReports();
	ExtentTest test;
	@BeforeTest
	public void config()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);		
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Results");
		extent.attachReporter(reporter);
		extent.createTest("MyFirstTest").log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		extent.setSystemInfo("Tester", "Shravan V");
		
	}
	@Test
	public void initialDemo() throws IOException
	{
		ExtentTest test=extent.createTest("My Second Test");
		test.log(Status.PASS, "Second test executed");
		ExcelDemo e =new ExcelDemo();
		ArrayList<String> data=e.getData("Purchase");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
	}
	@AfterTest
	public void tearDown()
	{
		extent.flush();
	}
	
	
	
}
