package qaclickacademy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {
	public ArrayList<String> getData(String testcaseName) throws IOException
	{
	ArrayList<String> a= new ArrayList<String>();
	FileInputStream fis= new FileInputStream("C:\\Users\\SHRAVAN\\Desktop\\Book1.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	{
		int sheets=workbook.getNumberOfSheets();
		for (int i=0;i<sheets;i++)
		{			
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))  // sheet name is "testdata"
			{
				XSSFSheet sheet= workbook.getSheetAt(i);
			   Iterator<Row> rows= sheet.iterator();
			  Row firstrow= rows.next();
			  Iterator<Cell> cel=firstrow.cellIterator();
			  int k=0;
			  int column = 0;
			  while(cel.hasNext())
			  {
				  Cell value=cel.next();
				  if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
				  {
					  column=k;					  
				  }
				  k++;
				  //System.out.println(column);
				  while(rows.hasNext())
					  
				  {
					  Row r = rows.next();
					  if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
					  {
						  Iterator<Cell> cv= r.cellIterator();
						  while(cv.hasNext())
						  {
							  a.add(cv.next().getStringCellValue());
						  }		  
						  
					  }
				  }
			  }
			    
			}
		}
	}
	return a;	
}

	public static void main(String[] args) throws IOException {	
	
		ExcelDemo ed=new ExcelDemo();
		ArrayList<String> al=ed.getData("Login");
		System.out.println(al.get(0));
		System.out.println(al.get(1));
		System.out.println(al.get(2));
		System.out.println(al.get(3));
		}
}


