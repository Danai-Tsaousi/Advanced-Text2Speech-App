package Input;

import java.util.List;

public abstract class ReaderDecorator implements DocumentReader{
	private DocumentReader docR;
	
	public ReaderDecorator(DocumentReader rd) {
		this.docR = rd;
	}
	
	public List<String> read(String path){
		return docR.read(path);
	}
}
