package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReading {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	@Test
	public void excelread() throws Exception {
		
		File file=new File(System.getProperty("user.dir")+"\\ExcelTestdata\\data.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheetAt(0);
		int rowcount=sheet.getLastRowNum();
		XSSFRow row=sheet.getRow(0);
		int col=row.getLastCellNum();
		for(int i=0;i<rowcount;i++) {
			for(int j=0;j<col;j++) {
				String str=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(str);
			}
		}
		
		
		
		
		
		
	}

}
