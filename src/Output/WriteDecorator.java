package Output;

import java.util.List;

public abstract class WriteDecorator implements DocumentWriter{
	
	private DocumentWriter docW;
	
	public WriteDecorator(DocumentWriter dw) {
		this.docW = dw;
	}

	public List<String> write(String path, List<String> contents){
		return docW.write(path,contents);
	}
}
