package test_Data;

import org.apache.poi.ss.usermodel.Sheet;



import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class excell_sheet_info {

	
	public static Workbook book;
	public static Sheet sheet;
	//create object array
	public static <sheet> Object[][] readdata(String Sheetname){
		FileInputStream file=null;
		try {
			file=new FileInputStream("C:\\Users\\dixit\\eclipse-workspace\\Amazon\\src\\test\\java\\test_Data\\Details.xlsx");
		}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
		try {
			
	book=	WorkbookFactory.create(file); // HSSF (old version till2006) XSSF (2007 and onwards)
	}
		catch(IOException a ) {
			a.printStackTrace();
		}
		sheet=book.getSheet(Sheetname);
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++) {
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
}
	
	
}
