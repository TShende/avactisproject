package com.avactis.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	static XSSFWorkbook wb;
	static Object[][] exceldata = null;
	static XSSFCell celldata;
	static List<Map<String, String>> execldata2;
	private static XSSFSheet xssfSheet;
	private static FileInputStream fis;
	private static Logger logger = Logger.getLogger(ExcelFileReader.class.getName());
	
	private static void setup(String excelName, String sheetName) throws Exception {

		if (excelName == null && sheetName == null) {
			throw new Exception("ExcelDetails annotation is missing. It must be called at either Method level or class level. If both available, method level will have the priority over class level.");

		}		
		String folderPath = ConfigReader.getPropertyfromFile("avactis", "TestDataFolderpath");
		File xlsFile = new File(folderPath + File.separator + excelName + ".xls");
		File xlsxFile = new File(folderPath + File.separator + excelName + ".xlsx");
		if (xlsFile.exists()) {
			fis = new FileInputStream(xlsFile);
		} else if (xlsxFile.exists()) {
			fis = new FileInputStream(xlsxFile);
		} else {
			throw new Exception("Excel Details are not correct. Trying to load excel '" + excelName + "' and sheet name '" + sheetName + "'. Either or both of which are not available/wrong.");
		}
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
		xssfSheet = xssfWorkbook.getSheet(sheetName);
		if (xssfSheet == null) {
			xssfWorkbook.close();
			throw new Exception("Excel Sheet name is not correct. Trying to load sheet '" + sheetName + "' from excel '" + excelName + "', which looks like not available.");
		}
		xssfWorkbook.close();
	}

	public static Object[][] getData(String excelName, String sheetName) throws Exception {
		List<Object[]> results = new ArrayList<Object[]>();
		try {
			setup(excelName, sheetName);
			int numRows = xssfSheet.getLastRowNum();
			for (int i = 1; i <= numRows; i++) {
				Map<String, String> inputValues = getMapDataFromRow(xssfSheet, i);
				results.add(new Object[] { inputValues });
			}
		} catch (IOException e) {
			logger.warning(e.getMessage());
		}

		finally {
			IOUtils.closeQuietly(fis);
		}
		return results.toArray(new Object[0][]);
	}

	public static List<Map<String, String>> readData(String excelName, String sheetName) throws Exception {
		List<Map<String, String>> excelData = new ArrayList<Map<String, String>>();
		try {
			setup(excelName, sheetName);
			int numRows = xssfSheet.getLastRowNum();
			for (int i = 1; i <= numRows; i++) {
				Map<String, String> inputValues = getMapDataFromRow(xssfSheet, i);
				excelData.add(inputValues);
			}
		} catch (IOException e) {
			logger.warning(e.getMessage());
		} finally {
			IOUtils.closeQuietly(fis);
		}
		return excelData;
	}

	private static Map<String, String> getMapDataFromRow(Sheet sheet, int rowIndex) {
		Map<String, String> results = new LinkedHashMap<String, String>();
		String[] columnHeaders = getDataFromRow(sheet, 0);
		String[] valuesFromRow = getDataFromRow(sheet, rowIndex);
		for (int i = 0; i < columnHeaders.length; i++) {
			if (i >= valuesFromRow.length) {
				results.put(columnHeaders[i], "");
			} else {
				results.put(columnHeaders[i], valuesFromRow[i]);
			}
		}
		return results;
	}
	
	private static String[] getDataFromRow(Sheet sheet, int rowIndex) {
		Row row = sheet.getRow(rowIndex);
		short numCells = row.getLastCellNum();
		String[] result = new String[numCells];
		for (int i = 0; i < numCells; i++) {
			result[i] = row.getCell(i).toString();
		}
		return result;
	}
}
