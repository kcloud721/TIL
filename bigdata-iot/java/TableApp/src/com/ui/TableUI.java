package com.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import com.biz.MenuDb;
import com.biz.TableDb;
import com.frame.Db;
import com.vo.Menu;
import com.vo.Table;

public class TableUI {
	Frame frame;
	Panel p1, p2;
	Button[] orderButton = new Button[9];
	Panel[] orderPanel = new Panel[9];
	List[] orderList = new List[9];
	Label[] priceLabel = new Label[9];
	Label statusLabel = new Label();

	Db<Integer, Table> tableDb;
	Db<String, Menu> menuDb;

	ArrayList<Table> uList = new ArrayList<Table>();

	int[] prices = new int[9];

	public TableUI() {
		tableDb = new TableDb("db", "db");
		menuDb = new MenuDb("db", "db");

		makeUI();
		eventProcess();
	}

	public void makeUI() {
		frame = new Frame("Menu Page");
		p1 = new Panel();
		p2 = new Panel();

		orderButton[0] = new Button("Admin");
		for (int i = 0; i < orderPanel.length; i++) {
			orderPanel[i] = new Panel();
			orderList[i] = new List();

			if (i != 0) {
				orderButton[i] = new Button("Table " + i);
				orderList[i].setBackground(Color.pink);

			}

			orderPanel[i].add(orderButton[i], "North");
			if (i != 0) {
				orderPanel[i].add(orderList[i], "Center");
			}

		}
		selectAllOrder();
		calculatePrice();
		p1.add(orderPanel[0]);
		for (int i = 1; i < orderButton.length; i++) {
			priceLabel[i] = new Label("PRICE: " + prices[i]);
			orderPanel[i].add(priceLabel[i]);
			p1.add(orderPanel[i]);
		}

		statusLabel = new Label("Status: ");
		p2.add(statusLabel);

		p1.setLayout(new GridLayout(3, 3));
		frame.add(p1, "Center");
		frame.add(p2, "South");
		frame.setSize(500, 500);
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

	public void eventProcess() {
		for (int i = 0; i < orderButton.length; i++) {
			final int num = i;
			orderButton[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MenuUI menu = new MenuUI(orderButton[num].getLabel());
					frame.setVisible(false);
				}
			});
		}
	}

	public void selectAllOrder() {
		try {
			uList = tableDb.selectAll();

			while (true) {
				Table table = uList.remove(0);
				String[] str = table.getMenus().split(" ");

				for (int i = 0; i < str.length; i++) {
					orderList[table.getTableNo()].add(str[i]);
				}

				if (uList.isEmpty()) {
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("error");
		}
	}

	public void calculatePrice() {
		for (int i = 0; i < orderList.length; i++) {
			String str[] = orderList[i].getItems();

			for (int j = 0; j < str.length; j++) {
				try {
					prices[i] += menuDb.select(str[j]).getPrice();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		TableUI tableUi = new TableUI();
	}
}
