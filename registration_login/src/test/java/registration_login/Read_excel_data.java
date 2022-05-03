package registration_login;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_excel_data {
		public String[][]read_sheet()throws InvalidFormatException, IOException{
			File myfile=new File(".\\Test_data\\base.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(myfile);
			XSSFSheet mysheet=wb.getSheet("Sheet1");
			
			int rows=mysheet.getPhysicalNumberOfRows();
			int colums=mysheet.getRow(0).getLastCellNum();
			String[][] array=new String[rows-1][colums];
			for(int i=1;i<rows;i++) {
				for(int a=0; a<colums;a++) {
					XSSFRow rw=mysheet.getRow(i);
					array[i-1][a]=rw.getCell(a).getStringCellValue();
				}
			}
			
			return null;
		
		}
	}
