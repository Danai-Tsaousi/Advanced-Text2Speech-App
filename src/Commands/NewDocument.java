package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.Text2SpeechEditorAppView;

public class NewDocument implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Text2SpeechEditorAppView editor = new Text2SpeechEditorAppView();
		editor.createNewFrame();
	}

}
