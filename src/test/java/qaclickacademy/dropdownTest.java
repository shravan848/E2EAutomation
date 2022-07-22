package qaclickacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class dropdownTest {
	
	
	String dateDropdown="locator date";
	String monthDD="locator month";
	String yearDD="locator year";
	static WebDriver driver=null;	
			
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void ddTest(String date, String month, String year)
	{
		WebElement dd=driver.findElement(By.xpath(year));
		Select dropDown=new Select(dd);
		List<WebElement> ddOptions=dropDown.getOptions();
		
		int size=ddOptions.size();
		System.out.println("Size is :"+size);
		for( WebElement value: ddOptions)
			if(value.equals(date)) {
				System.out.println("selected date is :"+value);
				value.click();
			
		}
			
	}
	
	

}
