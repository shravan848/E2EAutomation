package qaclickacademy;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class timeTest {
  @Test
  public void method1() {
	  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date(); 
	    String Time=formatter.format(date);
	    System.out.println(Time);
	    
	    
  }
}
