package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	}
	
	
	public static int getCellCount(String xlfile, String xlsheet, int rowcount) throws IOException {
		fi= new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet= workbook.getSheet(xlsheet);
		row=sheet.getRow(rowcount);
	     int cellcount=	row.getLastCellNum();
		workbook.close();
		fi.close();
	    return cellcount; 
		
	}
	
	
	public static String getCellData(String xlfile, String xlsheet, int rowcount, int cellcount) throws IOException {
		fi= new FileInputStream(xlfile);
		workbook= new XSSFWorkbook(fi);
		sheet= workbook.getSheet(xlsheet);
		row= sheet.getRow(rowcount);
		cell= row.getCell(cellcount);
		//String celldata=cell.toString();
		String data;
		
		try {
		DataFormatter formatter= new DataFormatter();
		data=formatter.formatCellValue(cell);
		return data;
		}catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
		
	}
	
	
	public static void setCellData(String xlfile, String xlsheet, int rowcount, int cellcount,String inputdata) throws IOException {
		fi= new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet= workbook.getSheet(xlsheet);
		row= sheet.getRow(rowcount);
		cell= row.createCell(cellcount);
		cell.setCellValue(inputdata);
		fo= new FileOutputStream(xlfile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
	}
	
	public static void FillGreenColour(String xlfile, String xlsheet, int rowcount, int cellcount) throws IOException {
		fi= new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		row= sheet.getRow(rowcount);
		cell= row.getCell(cellcount);
		style= workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo= new FileOutputStream(xlfile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		
	}
	
	public static void FillRedColour(String xlfile, String xlsheet, int rowcount, int cellcount) throws IOException {
		fi= new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		row= sheet.getRow(rowcount);
		cell= row.getCell(cellcount);
		style= workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo= new FileOutputStream(xlfile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		
	}
	
	
	
}
