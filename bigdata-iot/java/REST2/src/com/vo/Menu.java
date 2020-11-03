package com.vo;

public class Menu {
	private String menu;
	private int price;
	
	public Menu() {}
	public Menu(String menu, int price) {
		this.menu= menu;
		this.price = price;
	}
	public String getMenu() {return menu;}
	public int getPrice() {return price;}
	public void setMenu(String menu) {this.menu = menu;}
	public void setPrice(int price) {this.price = price;}
	@Override
	public String toString() {
		return "Menu [menu=" + menu + ", price=" + price + "]";
	}
	
	
}
