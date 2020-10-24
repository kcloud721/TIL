package com.app;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Service;
import com.vo.User;

public class App {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("com.xml");
		System.out.println("Spring Started .......");

		//IoC
		User user = new User("id01", "pwd01", "james");
		Service<String,User> service = (Service)factory.getBean("userservice");
		service.register(user);
		
		User dbuser = null;
		dbuser = service.get("id01");
		System.out.println("Result: "+dbuser);
//		
//		ArrayList<User> list = null;
//		list = service.get();
//		for(User u:list) {
//			System.out.println(u);
//		}
//		
		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}

}
