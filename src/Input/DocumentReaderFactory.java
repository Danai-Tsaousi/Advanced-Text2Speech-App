package Input;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class DocumentReaderFactory {
	
	AtBashDecorator atBash ;
	Rot13Decorator rot13;
	
	public DocumentReaderFactory() {}
	
	public List<String> createReader(String path,String strategy, String filename) {
		
		String extension = "";
		List<String> list = new ArrayList<String>();
		List<String> decodedContents = new ArrayList<String>();
		ExcelReader exr;
		WordReader wr;
		int i = filename.lastIndexOf('.');
		if (i >= 0) {
		    extension = filename.substring(i+1);
		}
		
		if(extension.equals("docx")) {
			wr = new WordReader();
			list.addAll(wr.read(path));
			
			if(strategy.equals("Rot-13")){
				rot13 = new Rot13Decorator(wr);
				decodedContents.addAll(rot13.decodeRot(list));
				return decodedContents;
			}else if(strategy.equals("AtBash")) {
				atBash= new AtBashDecorator(wr);
				decodedContents.addAll(atBash.decodeAtb(list));
				return decodedContents;
			}else if(strategy.equals("No encoding")) {
				return list;
			}		
		
		}else if(extension.equals("xlsx")) {
			exr = new ExcelReader();
			list.addAll(exr.read(path));
			if(strategy.equals("Rot-13")){
				rot13 = new Rot13Decorator(exr);
				decodedContents.addAll(rot13.decodeRot(list));
				return decodedContents;
			}else if(strategy.equals("AtBash")) {
				atBash= new AtBashDecorator(exr);
				decodedContents.addAll(atBash.decodeAtb(list));
				return decodedContents;
			}else if(strategy.equals("No encoding")) {
				System.out.println(list);
				return list;
			}	
		}
		
			
		
		return null;
		
		
	}
}
