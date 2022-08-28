package Input;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordReader implements DocumentReader {
	
	public WordReader() {}
	
	@Override
	public List<String> read(String path) {
		
		List<String> elements = new ArrayList<String>();
		
		 try {
             File file = new File(path);
             FileInputStream fis = new FileInputStream(file.getAbsolutePath());

             XWPFDocument document = new XWPFDocument(fis);

             List<XWPFParagraph> paragraphs = document.getParagraphs();


             for (XWPFParagraph para : paragraphs) {
                
                 elements.add(para.getText());
             }
             fis.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
		 
		return elements;
	}

}
