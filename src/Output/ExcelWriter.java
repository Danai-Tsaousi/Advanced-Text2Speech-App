package Output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter implements DocumentWriter{
	private List<String> elements;
	public static Row row;
	public ExcelWriter() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<String> write(String filepath,List<String> contents){
		
		elements = new ArrayList<String>();
		elements.addAll(contents);
		
	    try {
	    	//writing workbook into the file
		    File file = new File(filepath);
	    	FileOutputStream outputStream = outputStream = new FileOutputStream(file);
	    	
	    	//create blank workbook
		    XSSFWorkbook workbook = new XSSFWorkbook();
		    //create blank sheet
		    XSSFSheet sheet = workbook.createSheet("Java Books");
		    
		    XSSFRow row;
		    String mystr = elements.get(0);
		    String[] ars = mystr.split(" ");
		    List<String> list = Arrays.asList(ars);
		    
		    int rowCount=0;
		    row = sheet.createRow(rowCount);
		    for(int i=0;i<list.size();i++) {
		    	if(list.get(i).equals("\n")) {
		    		continue;
		    	}else {
		    		Cell cell = row.createCell(i);
		    		cell.setCellValue(list.get(i));
		    	}
		    }
		    
		
		    workbook.write(outputStream);
		    outputStream.flush();
		    outputStream.close();
		    workbook.close();
		   
	    }catch (IOException e) {
	    	e.printStackTrace();
	    }
	    return elements;
	    
	}

}
