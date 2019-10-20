package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public static String TESTDATA_SHEET_PATH = "/Users/marat/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCRM_TestData.xlsx";

	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		System.out.println(sheet.getLastRowNum() + "----" + sheet.getRow(0).getLastCellNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
//				System.out.println(data[i][j]);
			}
		}
		return data;
	}

//	// Main function is calling readExcel function to read data from excel file
//
//		public void main(String... strings) throws IOException {
//
//			// Create an object of ReadGuru99ExcelFile class
//
//			Utility objUtility = new Utility();
//
//			// Prepare the path of excel file
//
//			String TESTDATA_FILE_PATH = "/Users/marat/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/testdata/";
//
//			// Call read file method of the class to read data
//
//			objUtility.readExcel(TESTDATA_FILE_PATH, "FreeCRM_TestData.xlsx", "Contacts");
//
//		}

//	public void readExcel(String TESTDATA_FILE_PATH, String fileName, String sheetName) throws IOException {
//
//		// Create an object of File class to open xlsx file
//
//		File file = new File(TESTDATA_FILE_PATH + "\\" + fileName);
//
//		// Create an object of FileInputStream class to read excel file
//
//		FileInputStream inputStream = new FileInputStream(file);
//
//		Workbook book = new XSSFWorkbook(inputStream);
//
//		// Read sheet inside the workbook by its name
//
//		Sheet sheet = book.getSheet(sheetName);
//
//		// Find number of rows in excel file
//
//		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//
//		// Create a loop over all the rows of excel file to read it
//
//		for (int i = 0; i < rowCount + 1; i++) {
//
//			Row row = sheet.getRow(i);
//
//			// Create a loop to print cell values in a row
//
//			for (int j = 0; j < row.getLastCellNum(); j++) {
//
//				// Print Excel data in console
//
//				System.out.print(row.getCell(j).getStringCellValue() + "|| ");
//
//			}
//
//			System.out.println();
//		}

//	}

}
