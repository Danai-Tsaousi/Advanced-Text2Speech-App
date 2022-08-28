package Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DocumentWriterFactory {
	
	AtBashDecorator atBash ;
	Rot13Decorator rot13;
	
	public DocumentWriterFactory() {}
	
	public List<String> createWriter(String path,String strategy, String filename,List<String> contents) {
		
		String extension = "";
		List<String> list = new ArrayList<String>();
		List<String> encodedContents = new ArrayList<String>();
		ExcelWriter exr;
		WordWriter wr;
		int i = filename.lastIndexOf('.');
		if (i >= 0) {
		    extension = filename.substring(i+1);
		}
		
		if(extension.equals("docx")) {
			wr = new WordWriter();
			list.addAll(wr.write(path,contents));
			//list.addAll(contents);
			if(strategy.equals("Rot-13")){
				rot13 = new Rot13Decorator(wr);
				encodedContents.addAll(rot13.encodeRot(list));
				return wr.write(path,encodedContents);
			}else if(strategy.equals("AtBash")) {
				atBash= new AtBashDecorator(wr);
				encodedContents.addAll(atBash.encodeAtb(list));
				return wr.write(path,encodedContents);
			}else if(strategy.equals("No encoding")) {
				return list;
			}		
		
		}else if(extension.equals("xlsx")) {
			exr = new ExcelWriter();
			list.addAll(exr.write(path,contents));
			
			if(strategy.equals("Rot-13")){
				rot13 = new Rot13Decorator(exr);
				encodedContents.addAll(rot13.encodeRot(list));
				return exr.write(path,encodedContents);
			}else if(strategy.equals("AtBash")) {
				atBash= new AtBashDecorator(exr);
				encodedContents.addAll(atBash.encodeAtb(list));
				return exr.write(path,encodedContents);
			}else if(strategy.equals("No encoding")) {
				return list;
			}	
		}
		
			
		
		return null;
		
	}
}
