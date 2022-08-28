package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import Model.Document;
import View.Text2SpeechEditorAppView;

public class OpenDocument implements ActionListener {
	

	public void setReplayManager() {
		
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		Text2SpeechEditorAppView editor = new Text2SpeechEditorAppView();
		
		editor.openFile();
		
	}	
	
}
