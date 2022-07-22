package qaclickacademy;

import org.testng.annotations.Test;

public class login extends BaseClass {
	
	@Test
	public void loginTest()
	{
		driver.get("https://www.google.com/");
		System.out.println("Login Test done");
		log.info("URL is opened");
		
		System.out.println("username :"+username);
		
	}

}
