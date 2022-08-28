package Input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader implements DocumentReader {//TO ELENJAME LEITOURGEI
	private List<String> elements;
	
	public ExcelReader() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<String> read(String filepath) {
		
		elements = new ArrayList<String>();
		
		File file = new File(filepath);
		FileInputStream inputStream = null;
		
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//get first sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		for (int i=0;i<rowCount+1;i++) {
			Row row = sheet.getRow(i);
			
			for (int j=0;j< row.getLastCellNum();j++) {
				
				elements.add(row.getCell(j).getStringCellValue());
			}
		}
		return elements;
		
	}
		
}


