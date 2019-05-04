package com.crm.qa.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
public class TestUtil {
	
	public static long PAGE_LOAD_TIME_OUT=20;
	public static long IMPLICIT_WAIT=10;
	public static String TEST_DATA_EXCELSHEET_PATH="C:\\Eclipse\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\CRMTestData.xlsx";
	public static XSSFWorkbook ExcelWBook;
	public static XSSFSheet ExcelWSheet;
	public static XSSFRow Row;
	public static XSSFCell Cell;
	
	public static Object[][] getCRMExcelSheetData(String Sheetname) throws IOException
	{
		File file=new File(TEST_DATA_EXCELSHEET_PATH);
		FileInputStream testdata=new FileInputStream(file);
		ExcelWBook= new XSSFWorkbook(testdata);
		ExcelWSheet=ExcelWBook.getSheet(Sheetname);
		
		int row_count=ExcelWSheet.getLastRowNum();
		int col_count=ExcelWSheet.getRow(0).getLastCellNum();
		System.out.println("row count"+row_count);
		System.out.println("column count"+col_count);
		Object[][] data=new Object[row_count][col_count];
		for(int i=0;i<row_count;i++)
		{
			for(int j=0;j<col_count;j++)
			{
				data[i][j]=ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(data[i][j]);
						
			}
		}
		return data;
	}
	
	

}
