package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.base.Base;

public class TestUtil extends Base{
	public TestUtil() throws IOException{
		super();
	}
	public static long PAGE_LOAD_TIMEOUT=10;
	public static long IMPLICIT_WAIT=3;
	public static String TESTDATA_SHEET=".//Resources//com//qa//testdata//QATestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file=null;
		try {
			file=new FileInputStream(TESTDATA_SHEET);
			
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			
			book=WorkbookFactory.create(file);
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//System.out.println(sheet.getLastRowNum());
		//System.out.println(sheet.getRow(0).getLastCellNum());
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for (int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				//System.out.println(data[i][k]);
			}
		}
		return data;
		
	}
	
}