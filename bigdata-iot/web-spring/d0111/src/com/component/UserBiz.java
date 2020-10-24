package com.component;

import org.springframework.stereotype.Component;

import com.biz.Biz;
@Component("ubiz")
public class UserBiz implements Biz {

	@Override
	public void register() {
		System.out.println("user register");
	}

	@Override
	public void remove() {
		System.out.println("user remove");

	}

	@Override
	public void modify() {
		System.out.println("user modify");

	}

}
