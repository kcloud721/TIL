package app;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

public class App {
	
	Frame frame;
	Panel p1,p2,p3, sp1,sp2;
	Button b1, b2;
	TextField tf1, tf2, tf3;
	List list;
	Label label;
	
	TextField stf1, stf2, stf3;
	Button upbt;
	
	Db<String, User> userDb;
	ArrayList<User> ulist = null; //----------------------
	public App() {}
	public App(Db<String, User> userDb) {
		this.userDb = userDb;
		makeUi();
		eventProcess();
	}
	
//	public App() {
//		userDb = new UserDb("127.0.0.1", "db", "db");
//		makeUi();
//		eventProcess();
//	}
	public void makeUi() {
		frame = new Frame("My Name");
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		tf3 = new TextField(10);
		b1 = new Button("ADD");
		b2 = new Button("SEARCH");
		
		label = new Label("Status: ");
		p3.setLayout(new BorderLayout());
		p3.add(label); 
		
		//서브패널
		sp1 = new Panel(); sp1.setBackground(Color.white);
		sp2 = new Panel(); sp2.setBackground(Color.black);
		
		//sp2에 들어갈 것들 > 
		stf1 = new TextField();
		stf2 = new TextField();
		stf3 = new TextField();
		upbt = new Button("UPDATE");
		
		sp2.setLayout(new GridLayout(4,1)); //4행1열
		sp2.add(stf1); sp2.add(stf2); sp2.add(stf3);
		sp2.add(upbt);
		
		
		p1.add(tf1); p1.add(tf2); p1.add(tf3);
		p1.add(b1); p1.add(b2);
		
		list = new List();
		list.setBackground(Color.yellow);
		sp1.setLayout(new BorderLayout()); //패널로 만든다는건가
		sp1.add(list);
		
		p2.setLayout(new GridLayout(1,2)); //1행 2열
		p2.add(sp1); p2.add(sp2);
		
		p1.setBackground(Color.blue);
		p2.setBackground(Color.gray);
		p3.setBackground(Color.cyan);
		//frame.setLayout(new GridLayout(3, 1)); //3행 1열
		frame.add(p1, "North");
		frame.add(p2, "Center");
		frame.add(p3, "South");
		
		frame.setSize(500, 600);
		frame.setLocation(300, 200);
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
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		frame.setVisible(true);
		
	}
	
	public void eventProcess() {
		list.addItemListener(new ItemListener() { //왼쪽 아이템 클릭하면 해당정보 sp2에 뿌림
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int index = list.getSelectedIndex();
				User user = ulist.get(index);
				// setLabel(list.getItemCount()+""); //+"" 로 integer > string으로 변환
				stf1.setText(user.getId());
				stf2.setText(user.getPwd());
				stf3.setText(user.getName());

			}
		});
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				b1.setBackground(Color.black);
				insertUser();
				b1.setForeground(Color.white);
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectUser();
			}
		});
		upbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateUser();
			}
		});
	}
	
	public void setLabel(String str) {
		label.setText("Status: "+str);
		
	}
	
	public void updateUser() {
		String id = stf1.getText();
		String pwd = stf2.getText();
		String name = stf3.getText();
		User user = new User(id, pwd, name);
		try {
			userDb.update(user);
			selectUser();
			setLabel("User Updated");
		} catch (Exception e) {
			setLabel("Updated Fail");
			e.printStackTrace();
		}
	}
	
	public void insertUser() {
		String id = tf1.getText();
		String pwd = tf2.getText();
		String name = tf3.getText();
		User user = new User(id, pwd, name);
		try {
			userDb.insert(user);
			selectUser(); //인서트 후 다시 셀렉트
			setLabel("User Insert Completed");
		} catch (Exception e) {
			setLabel("User Insert Fail");
			e.printStackTrace();
		}
		
	}
	
	public void selectUser() {
		ulist = null;
		try {
			ulist = userDb.select();
			list.removeAll();
			for(User u: ulist)
				list.add(u.getId()+" "+u.getName());
				//System.out.println(u);
			setLabel("Search Completed");
		} catch (Exception e) {
			setLabel("Search Fail !!");
			//e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		App app = new App();
//	}

}
