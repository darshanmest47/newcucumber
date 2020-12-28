package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {
	
	
	
	public static String ExcelReader(String path) throws IOException {
		File f1 = new File(path);
		FileInputStream fin = new FileInputStream(f1);
		String uname = null;
		
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet sh = wb.getSheet("data1");
		int rnum = sh.getLastRowNum();
		
		
		for(int i=1;i<=rnum;i++) {
		System.out.println("row at "+i);
		int cellnum = sh.getRow(i).getLastCellNum();
		
		
		for(int j=0;j<cellnum;j++) {
			 String val = sh.getRow(i).getCell(j).getStringCellValue();
			 
			 uname = val;
		}
	   
		}
		
		return uname;
	}

}
