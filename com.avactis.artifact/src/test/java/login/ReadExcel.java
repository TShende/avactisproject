package login;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
	
		File src = new File("D:\\Excel Data\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
	
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		int rowcount = sheet1.getLastRowNum();
		
		System.out.println(rowcount);
		
		for(int i =0; i < rowcount+1; i++)
		{
			String data = sheet1.getRow(i).getCell(1).getStringCellValue();			
			System.out.println(data);
		}
		
		
		
		wb.close();
	}
	
	

}
