package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Document;

public class exitDocument implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Document d = new Document();
		System.out.println("Time to exit !!");
		System.exit(1);

	}

}
