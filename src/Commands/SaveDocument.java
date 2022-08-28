package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Document;
import View.Text2SpeechEditorAppView;

public class SaveDocument implements ActionListener{
	   
		public SaveDocument() {}
		public void setDocument(Document doc) {}
		public void setReplayManager(ReplayManager rm) {}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Text2SpeechEditorAppView editor = new Text2SpeechEditorAppView();
			editor.saveFile();
	    } 
}
