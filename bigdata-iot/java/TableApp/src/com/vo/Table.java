package com.vo;

public class Table {
	private int tableNo;
	private String menu;
	public Table() {}
	public Table(int tableNo, String menu) {
		this.tableNo=tableNo;
		this.menu=menu;
	}
	public int getTableNo() {return tableNo;}
	public void setTableNo(int tableNo) {this.tableNo = tableNo;}
	public String getMenus() {return menu;}
	public void setMenus(String menu) {this.menu = menu;}
	@Override
	public String toString() {
		return "Table [tableNo=" + tableNo + ", menu=" + menu + "]";
	}
}
