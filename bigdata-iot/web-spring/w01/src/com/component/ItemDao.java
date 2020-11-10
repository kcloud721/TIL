package com.component;

import java.util.ArrayList;

import com.frame.Dao;
import com.vo.Item;

public class ItemDao implements Dao<String, Item> {

	@Override
	public void insert(Item v) {
		System.out.println("ItemDao insert");
		
	}

	@Override
	public void update(Item v) {
		System.out.println("ItemDao update");
		
	}

	@Override
	public void delete(String k) {
		System.out.println("ItemDao delete");
		
	}

	@Override
	public Item select(String k) {
		Item item = new Item("k", 100);
		System.out.println("ItemDao select");
		return item;
	}

	@Override
	public ArrayList<Item> select() {
		System.out.println("ItemDao selectAll");
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item("it01",10000));
		list.add(new Item("it02",20000));
		list.add(new Item("it03",30000));
		list.add(new Item("it04",40000));
		list.add(new Item("it05",50000));
		return list;
	}

	

}






