package XL;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLWrite {

	public static void main(String[] args) throws IOException {
		// we need to write the xl
		FileOutputStream fo= new FileOutputStream(System.getProperty("user.dir")+"\\XLFiles\\"+"write.xlsx");
		// To create the woorkbook 
		XSSFWorkbook workbook = new XSSFWorkbook();
		// create the sheet on workbook 
		XSSFSheet sheet=workbook.createSheet("Mahesh");
		
		
		/*
		// Enter the row0 and cell0 inser the value 
						
		XSSFRow row0=sheet.createRow(0);
		
		XSSFCell cell0=row0.createCell(0);
		cell0.setCellValue("S.no");
		// Enter the row0 and cell1 inser the value 
		// create the cell1
		
		XSSFCell cell1 =row0.createCell(1);
		 cell1.setCellValue("Name");
	
		// Enter the row1 and cell0 inser the value 
		 
		XSSFRow row1= sheet.createRow(1);
		XSSFCell r1c0=row1.createCell(0);
		r1c0.setCellValue("1");
		
		// Enter the row1 and cell1 inser the value 
		XSSFCell r1c1=  row1.createCell(1);
          r1c1.setCellValue("Mahesh");
	*/
		Scanner sc= new Scanner(System.in);
		
		
		
		
		for(int r=0; r<=4;r++) {
			 XSSFRow row= sheet.createRow(r);
			for(int c=0; c<=4; c++) {
				System.out.println("Enter the data ");
				String inputs=sc.next();
				XSSFCell cell=row.createCell(c);
				cell.setCellValue(inputs);
			}
			
		}
		
		
		
	workbook.write(fo);
	workbook.close();
	fo.close();
	
	
	
	
	}
     
	
	
	
}
