package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import View.Text2SpeechEditorAppView;

public class ReplayManager implements ActionListener {
	
	private ArrayList<String> listOfCommands;
	
	public ReplayManager(ArrayList<String> listOfCommands) {
		this.listOfCommands = new ArrayList<>();;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Text2SpeechEditorAppView editor = new Text2SpeechEditorAppView();
		editor.replayAudio();
	}
}