package com.vo;

public class Table {
	private int tableno;
	private String menu;
	public Table() {
	}
	public Table(int tableno, String menu) {
		this.tableno = tableno;
		this.menu = menu;
	}
	public int getTableno() {
		return tableno;
	}
	public void setTableno(int tableno) {
		this.tableno = tableno;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	@Override
	public String toString() {
		return "Table [tableno=" + tableno + ", menu=" + menu + "]";
	}	
}
