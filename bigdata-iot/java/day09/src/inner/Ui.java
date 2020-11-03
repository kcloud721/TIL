package inner;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ui {
	Frame f;
	Button b;
	
	public Ui(){
		makeUi();
	}
	public void makeUi() {
		f = new Frame("My Frame");
		f.setSize(400,500);
		b = new Button("Click");
		f.add(b);
		f.setVisible(true);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		Ui ui = new Ui();
	}

}
