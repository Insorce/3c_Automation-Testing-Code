package XL;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLRead {

	public static void main(String[] args) throws IOException {
		// To read the XLSX
		// File Input Stream-- to read the xl sheet 
		// File Output Stream -- to write the xl sheet 
		// XSSFWorkbook -- to create or open the work book 
		// XSSFSheet-- to create the sheet or open the sheet 
		// XSSFRow-- to read the data into the rows or write the data into the row 
		// XSSFCell - to write the data into the cell or get the data into the cell 
		
		// Step-1 using file input stream to fine the path of the xlsheet 
		
		FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\XLFiles\\"+"InputData.xlsx");
		// Step-2 Open the work book 
		
		XSSFWorkbook workbook= new XSSFWorkbook(fi);
		
		// Step-3 open the sheet 
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		// Step-4 find out the row count 
		
		int row=sheet.getLastRowNum();
		// Step-5 find out the cell count 
		
		 int cell= sheet.getRow(0).getLastCellNum();
		 
		 for(int r=0; r<=row;r++) {
			    XSSFRow row1=sheet.getRow(r);
			 for(int c=0; c<=cell; c++) {
				XSSFCell cell1= row1.getCell(c);
				System.out.print(cell1+" ");
			 }
			 System.out.println();
		 }
		 
		workbook.close();
		fi.close();
		 

	}

}
