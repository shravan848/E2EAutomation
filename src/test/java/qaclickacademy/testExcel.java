package qaclickacademy;

import java.io.IOException;
import java.util.ArrayList;

public class testExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelDemo e =new ExcelDemo();
		ArrayList<String> data=e.getData("Purchase");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		

	}

}
