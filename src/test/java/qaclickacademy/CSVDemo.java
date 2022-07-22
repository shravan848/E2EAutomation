package qaclickacademy;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVDemo {
	String CSV_path="C:\\Users\\SHRAVAN\\Downloads\\TestData.csv";
	CSVReader csvReader;
	String[] csvCell;
	
	@Test
	public void dataRead_CSV() throws CsvValidationException, IOException
	{
		csvReader=new CSVReader(new FileReader(CSV_path));
		while((csvCell=csvReader.readNext())!=null)
		{
			LinkedList<String> ll=new LinkedList<String>();
			String CustomerName = csvCell[0];
            String CustomerEmail = csvCell[1];
            String CustomerPassword = csvCell[2];
            String CustomerConfirmPassword = csvCell[3];
            ll.add(CustomerName);
            ll.add(CustomerEmail);
            ll.add(CustomerPassword);
            ll.add(CustomerConfirmPassword);
            System.out.println(ll.get(0));
            
            /*System.out.println("cell 0 :"+CustomerName);
            System.out.println("cell 1 :"+CustomerEmail);
            System.out.println("cell 2 :"+CustomerPassword);
            System.out.println("cell 3 :"+CustomerConfirmPassword);
            System.out.println();*/
		}
	}
	

}
