package qaclickacademy;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest extends base {

	@Test
	public void BrowserAutomation() throws IOException
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date(); 
	    String time=formatter.format(date);
	    System.out.println("Time :"+time);
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHRAVAN\\Downloads\\chromedriver.exe");
	//WebDriverManager.chromedriver().setup();
	//WebDriver driver = new ChromeDriver();
	    initializeDriver();
	//driver.manage().window().maximize();
	driver.get("http://facebook.com");
	driver.findElement(By.cssSelector("input[name='email'")).sendKeys("shravan.1814@gmail.com");
	driver.findElement(By.cssSelector("input[type='password']")).click();
	driver.findElement(By.cssSelector("input[type='password']")).sendKeys("12345");
	driver.findElement(By.cssSelector("button[name='login']")).click();
	System.out.println(driver.findElement(By.xpath("//*[@id='error_box']")).getText());
	//File src=((TakesScreenshot)fbdriver).getScreenshotAs(OutputType.FILE);
	//Files.copy(src,new File("D:\\screenshot"+time+".jpeg"));
	logger.info("test_passed");
	
	//String path=System.getProperty("user.dir")+"\\Screenshots\\"+"screenshot.png";
	//Files.copy(src,new File(path));	
	//System.out.println("screenshot taken successfully");
	driver.quit();
	
	}
}
