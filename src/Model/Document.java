package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Input.DocumentReader;
import Input.DocumentReaderFactory;
import Output.DocumentWriter;
import Output.DocumentWriterFactory;
import View.Text2SpeechEditorAppView;

public class Document {
	
	public static List<String> contents  = new ArrayList<String>();
	
	private String filename;
	
	private DocumentReader docR;
	private DocumentReaderFactory drF;
	private DocumentWriter docW;
	private DocumentWriterFactory dwF;
	String filepath;
	
	public Document(String filename) {
		this.filename = filename;
	}
	/*Default */
	public Document() {}
	
	public void open(List<String> simpleFile){
			contents.addAll(simpleFile);	
	}
	
	public List<String> save(){
		return contents;
		
	}
	
	public void edit(String updatedContents) {
		contents.clear(); // erase the contents
		contents.add(updatedContents); // update our list with the edited
		
	}
	
	
	
	
	
	public void setFilepath(String absolutePath) {
		this.filepath=absolutePath;
	}
	public void setContents(List<String> simpleFile) {
		this.contents = simpleFile;
	}
	public List<String> getContents() {
		return contents;
	}

	

}
