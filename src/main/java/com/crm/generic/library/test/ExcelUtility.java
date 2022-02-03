package com.crm.generic.library.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility 
{
	public String getDataFromExcel(String sheet,int rowno,int cellno) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/TestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row row=sh.getRow(rowno);
		Cell cell=row.getCell(cellno);
		String data=row.getCell(cellno).getStringCellValue();
		return data;
	}
	
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/TestScript.xlsx");
		Workbook wb=new HSSFWorkbookFactory().create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowcount=sh.getLastRowNum();
		return rowcount;
	}
	
		public void setDataExcel(String sheetName,int rowNum,int celNum,String data) throws Throwable
		{
			FileInputStream fis=new FileInputStream("./data/TestScript.xlsx");
			Workbook wb=new HSSFWorkbookFactory().create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row=sh.getRow(rowNum);
			Cell cell=row.getCell(celNum);
			cell.setCellValue(data);
			FileOutputStream fos=new FileOutputStream("./data/testScript.xlsx");
			wb.write(fos);
			wb.close();
		}

}
