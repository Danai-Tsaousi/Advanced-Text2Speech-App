package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.Text2SpeechEditorAppView;

public class editDocument implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Text2SpeechEditorAppView editor = new Text2SpeechEditorAppView();
		editor.editFile();
		
	}

}
