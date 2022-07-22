package qaclickacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pagination {

	@Test
	public void paginationTest() throws InterruptedException
	{	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/pagination/");
		
		/*-------pagination---------------
		List<WebElement> pagination=driver.findElements(By.xpath("//*[@id=\"dtBasicExample_paginate\"]//a"));
		int pageSize=pagination.size();
		System.out.println("pages are :"+pageSize);
		int i=0;
		if( i<=pageSize)
		{
			for(WebElement ele:pagination)
			{
				System.out.println(ele.getText());				
				i++;			
			}
			
		}
		else
		{
			System.out.println("No more pages");
		}*/
		
		/*------------------Table Headers list------------
		List<WebElement> header=driver.findElements(By.xpath("//table[@id='dtBasicExample']/thead/tr/th"));
		int headerSize=header.size();
		System.out.println(headerSize);
		for(WebElement ele:header)
		{
			System.out.println(ele.getText());
		}*/
		
		/*------Table Body values-------
		List<WebElement> tbody=driver.findElements(By.xpath("//table[@id='dtBasicExample']/tbody/tr/td[1]"));
		int tbodySize=tbody.size();
		System.out.println("tbody size"+tbodySize);
		
		
		for (WebElement elem: tbody)
		{
			System.out.println(elem.getText());			
		
		} */
		/*-----find Salary is at which index-------
		List<WebElement> header=driver.findElements(By.xpath("//table[@id='dtBasicExample']/thead/tr/th"));
		for(WebElement ele:header)
		{
			if(ele.getText().contains("Salary"))
			{
				System.out.println("Salary Index is at :"+header.indexOf(ele));
			}
		}*/
		
		int sum=0;
		List<WebElement> salary=driver.findElements(By.xpath("//table[@id='dtBasicExample']/tbody/tr/td[6]"));
		for(WebElement sal: salary)
		{
			//int sala=Integer.parseInt(sal.getText().split("$")[1]);
			String salarySTR=sal.getText().replace("$", " ").trim();
			String sala=salarySTR.replace(",","").trim();
			int i =Integer.parseInt(sala);
			sum=sum+i;				
		}
		System.out.println("sum is :" +sum);
		driver.quit();
		
	
	}
	
}
