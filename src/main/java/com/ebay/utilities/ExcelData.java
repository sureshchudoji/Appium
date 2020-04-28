package com.ebay.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public FileInputStream file;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet;
	public Row row;
	public Cell cell;

	//Returns Username
	public String getUsername() throws IOException {
		Log.info("get Usrname");

		try {
			file = new FileInputStream(new File(System.getProperty("user.dir") + "\\data\\testData.xlsx"));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);

			row = sheet.getRow(1);
			cell = row.getCell(0);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			file.close();
		}
		Log.info("Username: "+cell.getStringCellValue());
		return cell.getStringCellValue();
	}

	//Returns Password
	public String getPassword() throws IOException {

		try {
			file = new FileInputStream(new File(System.getProperty("user.dir") + "\\data\\testData.xlsx"));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);

			row = sheet.getRow(1);
			cell = row.getCell(1);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			file.close();
		}
		Log.info("Password: "+cell.getStringCellValue());
		return cell.getStringCellValue();
	} 

} 

