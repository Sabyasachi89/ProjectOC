package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pageDataReading.PageLocatorsAndData;

public class DataReading {
	
	/*public HashMap<String, ArrayList<String>> ExcelReading() {
		// TODO Auto-generated constructor stub
		HashMap<String, ArrayList<String>> excelDataMap = new HashMap<String, ArrayList<String>>();
		
		return excelDataMap;
	}*/
	
	
	//Returning data page wise, when method is called page wise.
	/*public HashMap<String, ArrayList> pageValues(String sheetName){
		
		HashMap<String, ArrayList> excelDataMap = new HashMap<String, ArrayList>();
		
		ArrayList rowValues;
		
		int colIndex = 0;
		try {
			
			FileInputStream fis = new FileInputStream("C:\\Users\\sdeb\\eclipse-workspace\\IAP Automation\\Field Location.xlsx");
			Workbook workBook = new XSSFWorkbook(fis);
			
			Sheet sheet = workBook.getSheet(sheetName);
			
			Row header = sheet.getRow(0);
			Iterator<Cell> columns = header.cellIterator();
			while (columns.hasNext()) {
				
				Cell column = columns.next();
				String keyColumn = column.getStringCellValue();
				
				if (keyColumn.equalsIgnoreCase("Web Element")) {
					
					colIndex = column.getColumnIndex();
				}
			}
			
			
			Iterator<Row> rowIterator = sheet.rowIterator();
			rowIterator.next();
			
			String keyColumn = null;
			
			while(rowIterator.hasNext()) {
				
				rowValues = new ArrayList();
				
				Row row = rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					
					if (cell.getColumnIndex() == colIndex) {
						
						keyColumn = cell.getStringCellValue();
					} 
					else {
						
						if (cell.getCellType()==1) {
							rowValues.add(cell.getStringCellValue());
						} else {
							rowValues.add(cell.getNumericCellValue());
						}
					}
				}
				
				excelDataMap.put(keyColumn, rowValues);
			}
			
			
			for(Map.Entry<String, ArrayList> map : excelDataMap.entrySet()) {
				
				System.out.println(map.getKey() +" "+ map.getValue());
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
			return excelDataMap;
	}*/
	
	
	//Extracting data of all the pages at a time.
	
	PageLocatorsAndData pageLocatorsAndData = new PageLocatorsAndData();
	
	public DataReading() {
		// TODO Auto-generated constructor stub
	
		HashMap<String, ArrayList> excelDataMap = new HashMap<String, ArrayList>();
		
		ArrayList rowValues;
		
		int colIndex = 0;
		
		Workbook workBook = null;
		
		try {
			
			FileInputStream fis = new FileInputStream("C:\\Users\\sdeb\\eclipse-workspace\\IAP Automation\\Field Location.xlsx");
			workBook = new XSSFWorkbook(fis);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
			int numberOfSheets = workBook.getNumberOfSheets();
			
			for(int sheetNumber=0; sheetNumber<numberOfSheets; sheetNumber++) {
				
				System.out.println(workBook.getSheetName(sheetNumber));
				
				String sheetName = workBook.getSheetName(sheetNumber);
				
				Sheet sheet = workBook.getSheetAt(sheetNumber);
				
				Row header = sheet.getRow(0);
				Iterator<Cell> columns = header.cellIterator();
				while (columns.hasNext()) {
					
					Cell column = columns.next();
					String keyColumn = column.getStringCellValue();
					
					if (keyColumn.equalsIgnoreCase("Web Element")) {
						
						colIndex = column.getColumnIndex();
					}
				}
				
				
				System.out.println(sheet.getLastRowNum());
				Iterator<Row> rowIterator = sheet.rowIterator();
				rowIterator.next();
				
				String keyColumn = null;
				
				while(rowIterator.hasNext()) {
					
					rowValues = new ArrayList();
					
					Row row = rowIterator.next();
					
					Iterator<Cell> cellIterator = row.cellIterator();
					while(cellIterator.hasNext()) {
						
						Cell cell = cellIterator.next();
						
						if (cell.getColumnIndex() == colIndex) {
							
							keyColumn = cell.getStringCellValue();
						} 
						else {
							
							if (cell.getCellType()==1) {
								rowValues.add(cell.getStringCellValue());
							} else {
								rowValues.add(cell.getNumericCellValue());
							}
							
						}
					}
					
					excelDataMap.put(keyColumn, rowValues);
				}
				
				// calling the method for parsing the excel data.
				pageLocatorsAndData.readLocator(sheetName, excelDataMap);
				
				for(Map.Entry<String, ArrayList> map : excelDataMap.entrySet()) {
					
					System.out.println(map.getKey() +" "+ map.getValue());
				}
				
			}			
			
		} 
	
	
	/*public static void main(String[] args) throws IOException {
		
		HashMap<String, ArrayList> excelDataMap = new HashMap<String, ArrayList>();
		
		ArrayList rowValues;
		
		int colIndex = 0;
			
			FileInputStream fis = new FileInputStream("C:\\Users\\sdeb\\eclipse-workspace\\IAP Automation\\Field Location.xlsx");
			Workbook workBook = new XSSFWorkbook(fis);
			
			int numberOfSheets = workBook.getNumberOfSheets();
			
			for(int sheetNumber=0; sheetNumber<numberOfSheets; sheetNumber++) {
				
				System.out.println(workBook.getSheetName(sheetNumber));
				
				Sheet sheet = workBook.getSheetAt(sheetNumber);
				
				Row header = sheet.getRow(0);
				Iterator<Cell> columns = header.cellIterator();
				while (columns.hasNext()) {
					
					Cell column = columns.next();
					String keyColumn = column.getStringCellValue();
					
					if (keyColumn.equalsIgnoreCase("Web Element")) {
						
						colIndex = column.getColumnIndex();
					}
				}
				
				
				System.out.println(sheet.getLastRowNum());
				Iterator<Row> rowIterator = sheet.rowIterator();
				rowIterator.next();
				
				String keyColumn = null;
				
				while(rowIterator.hasNext()) {
					
					rowValues = new ArrayList();
					
					Row row = rowIterator.next();
					
					Iterator<Cell> cellIterator = row.cellIterator();
					while(cellIterator.hasNext()) {
						
						Cell cell = cellIterator.next();
						
						if (cell.getColumnIndex() == colIndex) {
							
							keyColumn = cell.getStringCellValue();
						} 
						else {
							
							if (cell.getCellType()==1) {
								rowValues.add(cell.getStringCellValue());
							} else {
								rowValues.add(cell.getNumericCellValue());
							}
							
						}
					}
					
					excelDataMap.put(keyColumn, rowValues);
				}
				
				
				for(Map.Entry<String, ArrayList> map : excelDataMap.entrySet()) {
					
					System.out.println(map.getKey() +" "+ map.getValue());
				}
				
			}
			
		} */

}
