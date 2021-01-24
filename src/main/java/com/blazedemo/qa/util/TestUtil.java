package com.blazedemo.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	public static long PAG_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	static XSSFWorkbook workbook;
	static XSSFSheet worksheet;
	static XSSFRow row;

	public static ArrayList<Object[]> getTestData() {
		ArrayList<Object[]> e2eData = new ArrayList<Object[]>();
		int totalNoOfRows = -1;
		try {
			FileInputStream fs = new FileInputStream(new File(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\blazedemo\\qa\\data\\E2EData.xlsx"));
			workbook = new XSSFWorkbook(fs);
			worksheet = workbook.getSheet("Sheet1");
			totalNoOfRows = worksheet.getLastRowNum();
		
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int rowCount = 1; rowCount <= totalNoOfRows; rowCount++) {

			row = worksheet.getRow(rowCount);
			String fromPort = row.getCell(0).toString();

			String toPort = row.getCell(1).toString();
			String passengerName = row.getCell(2).toString();
			String passengerAddress = row.getCell(3).toString();
			String passengerCity = row.getCell(4).toString();
			String passengerState = row.getCell(5).toString();
			String passengerZipCode = row.getCell(6).toString();
			String cardType = row.getCell(7).toString();
			String cardMonth = row.getCell(8).toString();
			String cardYear = row.getCell(9).toString();
			String cardName = row.getCell(10).toString();
			String cardNumber = row.getCell(11).toString();

			Object passengerDetails[] = { fromPort, toPort, passengerName, passengerAddress, passengerCity,
					passengerState, passengerZipCode, cardType, cardMonth, cardYear, cardName, cardNumber };

			e2eData.add(passengerDetails);
		}

		return e2eData;

	}
}
