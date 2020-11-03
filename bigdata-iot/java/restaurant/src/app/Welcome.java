package app;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.Table;

public class Welcome {
	Frame frame;
	Button bt1, bt2;
	Label label;
	Db<String, Table> userDb;
	
	public Welcome() {
		userDb = new UserDb("127.0.0.1", "db", "db");
		makeUi();
	}
	public void makeUi() {
		frame =  new Frame("Welcome");
				
		bt1 = new Button("1");
		bt2 = new Button("2");
		
		label = new Label();
		
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// login();
			}
		});
		
		frame.setLayout(new GridLayout(3,1));
		frame.add(bt1); frame.add(bt2);
		frame.add(label);
		
		//frame.addWindowListener(new addWindowListener); ///'''''
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				System.exit(0);	
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		frame.setLocation(300,300);
		frame.setSize(300,200);
		frame.setVisible(true);
	}
	
	public void inputNum(int input) {
		
	}
	
	public void login() {
		Table dbuser = null;
//		try {
//			dbuser = userDb.select(tid);
//			if(tpwd.equals(dbuser.getPwd())) {
//				frame.setVisible(false);
//				App app = new App(userDb);
//			} else {
//				label.setText("PWD XX");
//			}
//		} catch (Exception e) {
//			label.setText("ID XX");
//		}
	}
	
	public static void main(String[] args) {
		Welcome welcome = new Welcome();
	}

}
