package datadriven;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
	
	
	
	

	public static void main(String[] args) throws IOException {
		
		String path="G:\\ja\\datadriven\\src\\main\\resources\\TestData\\TestExcel1.xlsx";
		
		XSSFWorkbook book = new XSSFWorkbook();
		
		
		XSSFSheet sheet = book.createSheet("Sheet 1");
		
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(11);
		cell.setCellValue("Java Selenium");
		
		FileOutputStream out = new FileOutputStream(path);	
		book.write(out);
		
		
		
		
	}
	
	
	
	
	
	
	
}
