package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelManager {
	public FileOutputStream fo;
	public FileInputStream fi;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public excelManager(String path)
	{
		this.path = path;
	}
	
	public void recordAccount(String userName, String password, int rowNum) throws IOException
	{
		try //Try to load existing workbook
		{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		fi.close();
		}
		catch(IOException e) //make new workbook if the file doesn't exist
		{
		wb = new XSSFWorkbook();
		}
		
		ws = wb.getSheet("loginAccount");
		if(ws == null) //if sheet not created yet
		{
		ws = wb.createSheet("loginAccount");
		XSSFRow rowHeader = ws.createRow(0);
		XSSFCell cell1 = rowHeader.createCell(0);
		cell1.setCellValue("User Name");
		XSSFCell cell2 = rowHeader.createCell(1);
		cell2.setCellValue("Password");
		}
		
		// Write data row
        row = ws.createRow(rowNum);
        row.createCell(0).setCellValue(userName);
        row.createCell(1).setCellValue(password);

        fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fo.close();	
	}
	
	public String readLoginAccount(String sheet, int rowNum, int cellNum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet("loginAccount");
		cell = ws.getRow(rowNum).getCell(cellNum);
		String data = cell.toString();
		wb.close();
		fi.close();
		return data;
	}
	
	public int rowCount(String sheet) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		int rowNum = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowNum;
	}
	
	public int colCount(String sheet, int rowNum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		int colNum = ws.getRow(rowNum).getLastCellNum(); //getLastCellNum() index start from 1
		wb.close();
		fi.close();
		return colNum;
	}
}
