package Exceldata;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	
//	public static void main(String[] args) throws InvalidFormatException, IOException {
//		writeData("hello","random email");
//		System.out.println("Success");
//	}
	
	public static void writeData(String data,String val1) throws InvalidFormatException, IOException {
		File f1 = new File("E:\\ec5\\newcucu\\src\\main\\java\\Exceldata\\Randomdatagenerated.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("data1");
		
		XSSFRow row = sh.createRow(0);
		XSSFCell cell = row.createCell(0);
	
		
		cell.setCellValue(val1);
		System.out.println(val1);
		
		XSSFRow row1 = sh.createRow(1);
		XSSFCell cell1 = row1.createCell(0);
		cell1.setCellValue(data);
		System.out.println(data);
		
	
		FileOutputStream fout = new FileOutputStream(f1);
		wb.write(fout);
		wb.close();
		
	}

}
