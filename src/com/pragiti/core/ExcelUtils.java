package com.pragiti.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static final Logger LOG = LogManager.getLogger();
	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell cell;
	private static XSSFRow row;
	
	public static Object[][] getTableArray(String filePath, String sheetName)
			throws Exception {
		String[][] tabArray = null;
		try {
			FileInputStream excelFile = new FileInputStream(filePath);
			// Access the required test data sheet
			excelWBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
			int startRow = 0;
			int startCol = 0;
			int ci, cj;
			int totalRows = excelWSheet.getPhysicalNumberOfRows();// 1
			// you can write a function as well to get Column count
			// int totalCols = excelWSheet.getRow(0).getPhysicalNumberOfCells();

			int totalCols = excelWSheet.getRow(0).getLastCellNum();
			tabArray = new String[totalRows][totalCols];
			ci = 0;
			for (int i = startRow; i <= (totalRows - 1); i++, ci++) {
				cj = 0;
				for (int j = startCol; j <= (totalCols - 1); j++, cj++) {
					tabArray[ci][cj] = getCellData(i, j);
				}
			}
		}
		catch (FileNotFoundException e) {
			LOG.error("Could not read the Excel sheet" + e.getStackTrace());
		}
		catch (IOException e) {
			LOG.error("Could not read the Excel sheet" + e);
		}
		return (tabArray);
	}

	public static Object[][] getTableArray(String filePath, String sheetName, int ignoreRows, int ignoreColumns)
			throws Exception {
		String[][] tabArray = null;
		try {
			FileInputStream excelFile = new FileInputStream(filePath);
			// Access the required test data sheet
			excelWBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
			int startRow = 0+ignoreRows;
			int startCol = 0+ignoreColumns;
			int ci, cj;
			int totalRows = excelWSheet.getPhysicalNumberOfRows();// 1
			// you can write a function as well to get Column count
			// int totalCols = excelWSheet.getRow(0).getPhysicalNumberOfCells();

			int totalCols = excelWSheet.getRow(0).getLastCellNum();
			tabArray = new String[totalRows-ignoreRows][totalCols-ignoreColumns];
			ci = 0;
			for (int i = startRow; i <= (totalRows - 1); i++, ci++) {
				cj = 0;
				for (int j = startCol; j <= (totalCols - 1); j++, cj++) {
					tabArray[ci][cj] = getCellData(i, j);
				}
			}
		}
		catch (FileNotFoundException e) {
			LOG.error("Could not read the Excel sheet" + e.getStackTrace());
		}
		catch (IOException e) {
			LOG.error("Could not read the Excel sheet" + e);
		}
		return (tabArray);
	}
	
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			cell = excelWSheet.getRow(RowNum).getCell(ColNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				if (cell.getCellTypeEnum() == CellType.BLANK) {
				return " ";
			} else {
				DataFormatter formatter = new DataFormatter();
				String CellData = formatter.formatCellValue(cell);
				return CellData;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw (e);
		}
	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters
	public static void setCellData(String result, int rowNum, int colNum)
			throws Exception {
		try {
			row = excelWSheet.getRow(rowNum);
			cell = row.getCell(colNum, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK);
			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(result);
			} else {
				cell.setCellValue(result);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(
					CoreConstants.TestDataPath
							+ CoreConstants.LoginTestDataFile);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	// Returns test case name 
	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			throw (e);
		}
	}

	 //Gets the row data , in this we are passing parameters as  Test Case name and Col num
	public static int getRowContains(String sTestCaseName, int colNum)
			throws Exception {
		int i;
		try {
			int rowCount = ExcelUtils.getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (ExcelUtils.getCellData(i, colNum).equalsIgnoreCase(
						sTestCaseName)) {
					break;
				}
			}
			return i;
		} catch (Exception e) {
			throw (e);
		}
	}

	// Returns the row count 
	public static int getRowUsed() throws Exception {
		try {
			int rowCount = excelWSheet.getLastRowNum();
			return rowCount;
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw (e);
		}
	}

	// Returns a specific row identified by the test case id
	public static Object[][] getTableArray(String filePath, String sheetName, String sTestCaseName)throws Exception
	{
		
		String[][] tr=null;
		try {
			Object[][] tabArray=getTableArray(filePath, sheetName);
			int rN=getRowContains(sTestCaseName, 0);
			
			int cols=tabArray[rN-1].length;
			tr = new String[1][cols];

			for(int i=0;i<=cols-1;i++)
			{
				tr[0][i]=(String) tabArray[rN-1][i];
			}
		} catch (Exception e) {
			LOG.error("Could not read the Excel sheet" + e.getStackTrace());
		}
		
		return (tr);
	}
	
	public static String[] getRowArray(String filePath, String sheetName, int rowNum)throws Exception
	{
		
		String[][] tr=null;
		String[] trR=null;
		try {
			Object[][] tabArray=getTableArray(filePath, sheetName);
			int cols=tabArray[rowNum].length;
			tr = new String[1][cols];

			for(int i=0;i<=cols-1;i++)
			{
				tr[0][i]=(String) tabArray[rowNum][i];
			}
		} catch (Exception e) {
			LOG.error("Could not read the Excel sheet" + e.getStackTrace());
		}
		trR =tr[0];
		return (trR);
	}

}