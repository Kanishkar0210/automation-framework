package datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	
	public static void main(String[] args) throws IOException {
		String filePath ="G:\\ja\\datadriven\\src\\main\\resources\\TestData\\TestExcel.xlsx";
		
		
		
		FileInputStream inSt= new FileInputStream(filePath);	
		
		
		XSSFWorkbook book = new XSSFWorkbook(inSt);
		
		XSSFSheet sheetAt = book.getSheetAt(0);
		int lastRowNum = sheetAt.getLastRowNum();
		XSSFRow row = sheetAt.getRow(0);
		short lastCellNum = row.getLastCellNum();
		System.out.println("Excel Rows Total Count: "+(lastRowNum+1));
		System.out.println("Each Row has Total Cell :"+lastCellNum);
		
		XSSFCell cell = row.getCell(2);
		CellType cellType = cell.getCellType();
		System.out.println(cellType);
		
		
		SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
		
		for(int r=0; r<sheetAt.getLastRowNum();r++)
		{
			XSSFRow row2 = sheetAt.getRow(r);
			
			
			for(int col = 0;col<row2.getLastCellNum();col++) {
				
				
				XSSFCell cell2 = row2.getCell(col);
				CellType cellType2 = cell2.getCellType();
				
				switch(cellType2) {
				
				case STRING: 
					String stringCellValue = cell2.getStringCellValue();
				    System.out.println("String Value :"+stringCellValue);
				break;
				case BOOLEAN:
					boolean booleanCellValue = cell2.getBooleanCellValue();
				    System.out.println("Boolean Value is "+booleanCellValue);
				    break;
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell2)) {
						Date dateCellValue = cell2.getDateCellValue();
						String newDateformat = sim.format(dateCellValue);
						System.out.println(newDateformat);
					}
					else {
						double numericCellValue = cell2.getNumericCellValue();
						long num = (long)numericCellValue;
						System.out.println("NUmber Value is "+num);
					}
					break;
					
				case FORMULA:
					
					XSSFFormulaEvaluator formulaEvaluator = book.getCreationHelper().createFormulaEvaluator();
					XSSFCell evaluateInCell = formulaEvaluator.evaluateInCell(cell2);
					CellType formulaCellType = evaluateInCell.getCellType();
					switch(formulaCellType) {
					
					
					case STRING: 
						String stringCellValue1 = evaluateInCell.getStringCellValue();
					    System.out.println("String Value :"+stringCellValue1);
					break;
					case BOOLEAN:
						boolean booleanCellValue1 = evaluateInCell.getBooleanCellValue();
					    System.out.println("Boolean Value is "+booleanCellValue1);
					    break;
					case NUMERIC:
						if(DateUtil.isCellDateFormatted(evaluateInCell)) {
							Date dateCellValue = evaluateInCell.getDateCellValue();
							String newDateformat = sim.format(dateCellValue);
							System.out.println(newDateformat);
						}
						else {
							double numericCellValue = evaluateInCell.getNumericCellValue();
							long num = (long)numericCellValue;
							System.out.println("NUmber Value is "+num);
						}
						break;
					
					}
					
					break;
					
					default:
						System.out.println("Unknown Cell type");
						break;
				    
				    
				    
				    
				}
				
				
				
				
				
			}
				System.out.println();
		}
		}
}
