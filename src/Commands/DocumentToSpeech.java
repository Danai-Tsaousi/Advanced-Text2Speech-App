package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Document;
import View.Text2SpeechEditorAppView;

public class DocumentToSpeech implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		Document document = new Document();
		Text2SpeechEditorAppView editor = new Text2SpeechEditorAppView();
		editor.play();
		
	}

}
