package com.component;

import com.biz.Biz;

public class ItemBiz implements Biz {

	@Override
	public void register() {
		System.out.println("item register");
	}

	@Override
	public void remove() {
		System.out.println("item remove");

	}

	@Override
	public void modify() {
		System.out.println("item modify");

	}

}
