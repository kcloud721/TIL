package com.ui;

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

import com.biz.MenuDb;
import com.biz.TableDb;
import com.frame.Db;
import com.vo.Menu;
import com.vo.Table;

public class MenuUI {
	String table;
	boolean isAdmin;
	Frame frame;
	Panel tablePanel, buttonPanel, bigPanel, leftPanel, rightPanel, bottomPanel;
	Label tableLabel, nameLabel, priceLabel, statusLabel;
	Button insertButton, updateButton, deleteButton, sendButton;
	TextField nameTf, priceTf;

	List menuList;

	Db<String, Menu> menuDb = new MenuDb("db", "db");
	Db<Integer, Table> tableDb = new TableDb("db", "db");

	ArrayList<Menu> alist = new ArrayList<Menu>();

	public void selectAll() {
		menuList.removeAll();

		try {
			alist = menuDb.selectAll();
			for (Menu string : alist) {
				menuList.add(string.getMenu() + " " + string.getPrice());
			}
		} catch (Exception e) {
			statusLabel.setText("Select Error");
		}
	}

	public void insert() {
		try {
			Menu sample = new Menu(nameTf.getText(), Integer.parseInt(priceTf.getText()));
			menuDb.insert(sample);

			statusLabel.setText("Insert Complete");
		} catch (Exception e) {
			statusLabel.setText("Insert Error");
		}
		selectAll();
	}

	public void update() {
		try {
			Menu m = new Menu(nameTf.getText().trim(), Integer.parseInt(priceTf.getText().trim()));
			menuDb.update(m);
			statusLabel.setText("Update Complete");
		} catch (Exception e) {
			statusLabel.setText("Update Error");
			e.printStackTrace();
		}
		selectAll();
	}

	public void delete() {
		try {
			String str = menuList.getSelectedItem().split(" ")[0].trim();
			menuDb.delete(str);
			statusLabel.setText("Delete Complete");

			ArrayList<Table> tlist = tableDb.selectAll();
			for (Table t : tlist) {
				if (t.getMenus().contains(str)) {
					String[] arr = t.getMenus().split(" ");
					String tmp = "";
					for (int i = 0; i < arr.length; i++) {
						if(!arr[i].equals(str))
							tmp += arr[i] + " ";
					}
					Table t1 = new Table(t.getTableNo(), tmp);
					tableDb.update(t1);
				}
			}

		} catch (Exception e) {
			statusLabel.setText("Delete Error");
		}
		selectAll();
	}

	public void insertIntoTable() {
		String[] strarr = menuList.getSelectedItems();
		String sendStr = "";

		for (int i = 0; i < strarr.length; i++) {
			sendStr += strarr[i].split(" ")[0] + " ";
		}

		try {
			Table t = new Table(Integer.parseInt(table.split(" ")[1]), sendStr);
			tableDb.update(t);
		} catch (Exception e) {
			System.out.println("zzzzzzzzz");
		}

		statusLabel.setText(sendStr);
	}

	public MenuUI() {
		makeUI();
		eventProcess();
	}

	public MenuUI(String table) {
		this.table = table;
		isAdmin = table.equals("Admin");
		makeUI();
		eventProcess();
	}

	public void setNew() {
		List menuList;

		frame = new Frame(table);

		tablePanel = new Panel();
		bigPanel = new Panel();
		buttonPanel = new Panel();
		leftPanel = new Panel();
		rightPanel = new Panel();
		bottomPanel = new Panel();

		nameLabel = new Label("Name: ");
		priceLabel = new Label("Price: ");
		statusLabel = new Label("Status: ");
		insertButton = new Button("Insert");
		deleteButton = new Button("Delete");
		updateButton = new Button("Update");
		sendButton = new Button("Send");

		nameTf = new TextField(10);
		priceTf = new TextField(10);

		tableLabel = new Label(table);
	}

	public void setTableNum() {
		tablePanel.add(tableLabel);
		tablePanel.setBackground(Color.yellow);
	}

	public void setLeftField() {
		if (isAdmin) {
			buttonPanel.add(insertButton);
			buttonPanel.add(updateButton);
			buttonPanel.add(deleteButton);
		}
		leftPanel.add(buttonPanel);

		menuList = new List(13, !isAdmin);
		selectAll();
		// setTableChoice();
		leftPanel.add(menuList);

		bigPanel.add(leftPanel);
	}

	public void setRightField() {
		Panel p1 = new Panel();
		Panel p2 = new Panel();

		if (isAdmin) {
			p1.add(nameLabel);
			p1.add(nameTf);
			p2.add(priceLabel);
			p2.add(priceTf);

			rightPanel.setLayout(new GridLayout(4, 1));
			rightPanel.add(p1);
			rightPanel.add(p2);
		}
		rightPanel.add(sendButton, "Center");
		bigPanel.add(rightPanel);
	}

	public void setBottonField() {
		statusLabel.setBackground(Color.pink);
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(statusLabel);
	}

	public void makeUI() {
		setNew();

		setTableNum();

		setLeftField();
		setRightField();
		bigPanel.setLayout(new GridLayout(1, 2));

		setBottonField();

		frame.add(tablePanel, "North");
		frame.add(bigPanel, "Center");
		frame.add(bottomPanel, "South");

		frame.setSize(500, 350);
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
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		frame.setVisible(true);
	}

	private void eventProcess() {
		menuList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (isAdmin) {
					String idx = menuList.getSelectedItem();
					nameTf.setText(idx.split(" ")[0].trim());
					priceTf.setText(idx.split(" ")[1].trim());
				}
			}
		});
		insertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		;
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});

		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isAdmin) {
					insertIntoTable();
				}
				TableUI tableUI = new TableUI();
				frame.setVisible(false);
			}
		});
	}

	public void setTableChoice() {
		try {
			String str = tableDb.select(Integer.parseInt(table.split(" ")[1])).getMenus();
			String[] arr = str.split(" ");
			String[] items = menuList.getItems();

			for (int i = 0; i < items.length; i++) {
				items[i] = items[i].split(" ")[0].trim();
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < items.length; j++) {
					if (arr[i].equals(items[j])) {
						menuList.select(j);
					}
				}
			}
			statusLabel.setText("choice setting complete");
		} catch (Exception e) {
			statusLabel.setText("choice setting error");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	}
}
