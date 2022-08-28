/*Pinelopi Eleftheriadi 3221
 * Athanasia-Danai Tsaousi 3349
 */

package View;
import  Model.*;
import Output.DocumentWriterFactory;
import Commands.*;
import Input.DocumentReader;
import Input.DocumentReaderFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Text2SpeechEditorAppView {
	Document doc;
	JTextArea text;
	static JFrame viewFrame,frame,editFrame;
	static JLabel display;
	private JMenuBar menuBar;
	private JMenu fileM,audioM,reverseM;
	private Path path;
	
	String strategy = "";
	
	public static JTextArea mytext;
	public static List<String> docContents = new ArrayList<String>();
	
	//FOR EDIT START
	JPanel editPanel;
	JLabel editLabel;
	//EDIT END 
	
	Document mydoc=new Document();
	
	
	private void makeFrame() {
		viewFrame = new JFrame("Text to Speech App");
		menuBar = new JMenuBar();
	}
	
	private void makeMenu() {
		
		CommandsFactory comf = new CommandsFactory();
		
		//MENU FOR THE FILE
		fileM = new JMenu("FILE");
		menuBar.add(fileM);
		
		//MENU ITEMS
		JMenuItem item_edit = new JMenuItem("EDIT");
		JMenuItem item_open = new JMenuItem("OPEN");
		JMenuItem item_save = new JMenuItem("SAVE");
		JMenuItem item_exit = new JMenuItem("EXIT");
		//ADD MENU ITEMS TO JMENU
		fileM.add(item_edit);
		fileM.add(item_open);
		fileM.add(item_save);
		fileM.add(item_exit);
		
		//ADD ACTION LISTENER
		item_edit.addActionListener(comf.createCommand("Edit"));
		item_open.addActionListener(comf.createCommand("Open"));
		item_save.addActionListener(comf.createCommand("Save"));
		item_exit.addActionListener(comf.createCommand("Exit"));
	
		//AUDIO MENU
		audioM = new JMenu("AUDIO");
		menuBar.add(audioM);
		JMenuItem item_audio = new JMenuItem("PLAY");
		audioM.add(item_audio);
		item_audio.addActionListener(comf.createCommand("Document to Speech"));
		
		//REVERSE MENU
		reverseM = new JMenu("REPLAY");
		menuBar.add(reverseM);
		JMenuItem item_replay = new JMenuItem("REPLAY");
		reverseM.add(item_replay);
		item_replay.addActionListener(comf.createCommand("ReplayDocument"));
	
		
		viewFrame.setJMenuBar(menuBar);
		viewFrame.setSize(600,600);
		viewFrame.setVisible(true);
	}
	

	public void openFile() {
		Path filename;
		String p ;
		String[] options = {"Rot-13", "AtBash", "No encoding"};
		List<String> simpleFile = new ArrayList<String>();
		String strat;
		/*EDW ZHTAME APO TON XRISTI TO PATH,TO STRATEGY KAI THA DINOYME TO FILENAME STHN DOCUMENT(OPEN())*/
		JFrame pop = new JFrame();
		p= (String)JOptionPane.showInputDialog(pop, "Input the path of the file",null);
		path = Paths.get(p);
		filename = path.getFileName();
		
		JFrame pop1 = new JFrame();
		strat =  (String)JOptionPane.showInputDialog(null, "Please select one option", 
                "Encoding Method",JOptionPane.QUESTION_MESSAGE,null, options, options[2]);
		
		/*EDW KALOUME THN INPUT GIA NA METATREPSI TO ARXEIO SE APLI MORFH KAI NA TO APOKODIKOPOIHSH*/
		DocumentReaderFactory docReaderFactory = new DocumentReaderFactory();
		simpleFile.addAll(docReaderFactory.createReader(p, strat, filename.toString()));
		
		mydoc.open(simpleFile);
		mydoc.setContents(simpleFile);
		
		docContents.addAll(mydoc.getContents());
		
		display = new JLabel();
		display.setText(String.join("", docContents));
		JPanel panel = new JPanel();
		panel.add(display);
		viewFrame.add(panel);
		viewFrame.setVisible(true);
	}
	

	public void saveFile() {
		Document docS = new Document();
		List<String> mylist = new ArrayList<String>();
		mylist.addAll(mydoc.getContents());
		String[] options = {"Rot-13", "AtBash", "No encoding"};
		//mylist.addAll(docS.save());
		
		JFrame pop1 = new JFrame();
		//strategy = (String)JOptionPane.showInputDialog(pop1, "Input the strategy",null);
		strategy = (String)JOptionPane.showInputDialog(null, "Please select one option", 
                "Encoding Method",JOptionPane.QUESTION_MESSAGE,null, options, options[2]);
		// Create an object of JFileChooser class 
	       JFileChooser jfile = new JFileChooser("f:"); 

	       // Invoke the showsSaveDialog function to show the save dialog 
	       int show = jfile.showSaveDialog(null); 

	       if (show == JFileChooser.APPROVE_OPTION) { 

	           // Set the label to the path of the selected directory 
	           File fil = new File(jfile.getSelectedFile().getAbsolutePath()); 
	           
	           DocumentWriterFactory docWFactory = new DocumentWriterFactory();
	           docWFactory.createWriter(fil.getAbsolutePath(), strategy, fil.getName(), mylist);
	          
	       } 
	       // If the user cancelled the operation 
	       else
	           JOptionPane.showMessageDialog(frame, "the user cancelled the operation"); 
	}


	public void editFile() {
	
		List<String> editcontents = new ArrayList<String>();
		editcontents.addAll(docContents);
		
		editFrame = new JFrame("Edit Section");
		editFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		editLabel = new JLabel();
		//text area (show and edit)
		JTextArea editArea = new JTextArea(50,50);
		JScrollPane scroll = new JScrollPane(editArea);
		JButton but = new JButton("Save");
		but.setBounds(50,100,95,30);
		
		editArea.setEditable(true);
		editArea.append(String.join("",editcontents));
		
		editPanel= new JPanel();
		
		//add label and text area to panel
		editPanel.add(editLabel);
		editPanel.add(editArea);
		
		Text2SpeechEditorAppView ts = new Text2SpeechEditorAppView();
		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mydoc.edit(editArea.getText());
				ts.saveFile();
			}
		});
		
		editFrame.add(but);
		editFrame.add(editPanel);
		//make size of frame(window)
		editFrame.setSize(1000,1000);
		editFrame.setVisible(true);
		
	}	
	
	public void play() {
	
		List<String> playcontents = new ArrayList<String>();
		playcontents.addAll(mydoc.getContents());
		TTSFacade tf= new TTSFacade();
		for(String con : playcontents) {
			tf.play(con);
		}
	}
	
	public void replayAudio() {
		List<String> replaycontents = new ArrayList<String>();
		replaycontents.addAll(mydoc.getContents());
		TTSFacade tf= new TTSFacade();
		for(String con : replaycontents) {
			tf.play(con);
		}
		
	}
	
	
	
	
public static void main(String[] args) {

	Text2SpeechEditorAppView app = new Text2SpeechEditorAppView();
	
	app.makeFrame();
	app.makeMenu();
	

}	


	
















	





	public Object getEditorText() {
		// TODO Auto-generated method stub
		return null;
	}


	

	

	public void createNewFrame() {
		// TODO Auto-generated method stub
		
	}



}
