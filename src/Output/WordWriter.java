package Output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordWriter  implements DocumentWriter {

	public  WordWriter() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<String> write(String path,List<String> contents) {
		
		List<String> elements = new ArrayList<String>();
		elements.addAll(contents);
		//Blank Document
	    try {
	    	
	    	FileOutputStream out;
	    	XWPFDocument document = new XWPFDocument();
	    	out = new FileOutputStream(new File(path));
	    	//Write the Document in file system
	    	
	    	//create Paragraph 
	    	XWPFParagraph paragraph = document.createParagraph(); 
	    	XWPFRun run = paragraph.createRun();
		      
		    run.setText(String.join("", contents));
		    document.write(out);
		    out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println("createparagraph.docx written successfully");
		
		return elements;
	}

}
