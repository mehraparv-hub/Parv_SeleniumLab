package com.myflight.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.myflight.base.base;

public class TestUtil extends base{
	
	public static int PAGE_LOAD_WAIT= 10;
	
public static int IMPLICIT_PAGE_WAIT= 20;


public static Object[][] Excel_reader(String Sheetname) 
{
	FileInputStream fis = null;
	try {
		fis = new FileInputStream("C:\\JavaProg\\MercuryTest\\src\\main\\java\\com\\myflight\\testdata\\registertestdata.xlsx");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	XSSFWorkbook workbook = null;
	try {
		workbook = new XSSFWorkbook(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	XSSFSheet sheet = workbook.getSheet(Sheetname);
	
	String sheetname = sheet.getSheetName();
	
	
	//get the total number of rows
	
	int total_row = sheet.getLastRowNum();
	System.out.println(total_row);
	
	//total number of cols
	int col = sheet.getRow(0).getLastCellNum();
	
	
	System.out.println(col);
	
	Object [][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for(int i=0; i<total_row; i++)
	{
		for(int k=0; k<col; k++)
		{
			
			data[i][k] = sheet.getRow(i+1).getCell(k).getStringCellValue();
		}
	}
	
	return data;
	
}

}
