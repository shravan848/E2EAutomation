package Resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
	    Date date = new Date(); 
	    String Time=formatter.format(date);
	    System.out.println(Time);
		String path =System.getProperty("user.dir")+"\\reports\\index"+Time+".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rahul Shetty");
		return extent;
		
	}
}

