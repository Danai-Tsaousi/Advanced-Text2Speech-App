package Commands;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Commands.DocumentToSpeech;
import Commands.OpenDocument;
import Commands.ReplayManager;
import Commands.SaveDocument;

	
public class CommandsFactory {
	private ArrayList<String> listOfCommands = new ArrayList<>();
	
	public ActionListener createCommand(String command){
		
			
			if(command.equals("Open")){
				listOfCommands.add("Open");
				return new OpenDocument();
			}
			
			else if(command.equals("Save")){
				listOfCommands.add("Save");
				return new SaveDocument();
			}
			else if(command.equals("Edit")){
				listOfCommands.add("Edit");
				return new editDocument();
			}
			else if(command.equals("Document to Speech")){
				listOfCommands.add("Document to Speech");
				return new DocumentToSpeech();
			}
			else if(command.equals("Exit")){
				return new exitDocument();
				
			}else if(command.contentEquals("ReplayDocument")) {
				return new ReplayManager(listOfCommands);
			}else {
				return new exitDocument();
			}
	}
	
}

