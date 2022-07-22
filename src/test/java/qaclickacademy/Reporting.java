package qaclickacademy;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Resources.Base;
//import Resources.ExtentReporter;
//import Resources.base;

public class Reporting extends Base implements ITestListener {
	ExtentReports extent;
	ExtentSparkReporter reporter;
	public ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="\\target"+"Test-Report-"+timestamp+".html";
		reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\target"+repName);
		System.out.println(System.getProperty("user.dir")+"\\target"+"\\target");
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Shravan");
		reporter.config().setDocumentTitle("Banking Project");
		reporter.config().setReportName("Functional Report");
		//reporter.config().setTestViewChartLocation(ChartLocation.TOP);
		reporter.config().setTheme(Theme.DARK);
		
	}
	
	

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest((result.getName()));
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot
		test=extent.createTest((result.getName()));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		String screenshotpath=System.getProperty(("user.dir")+"\\Screenshots\\"+result.getName()+".png");
		File f=new File(screenshotpath);
		if(f.exists())
		{
			try
			{
				test.fail("Screenshot is below : "+ test.addScreenCaptureFromPath(screenshotpath));
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest((result.getName()));
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
