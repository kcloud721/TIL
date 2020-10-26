package com.thread;

class Th extends Thread{
	String name;
	
	public Th() {
		
	}
	public Th(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for(int i=0; i<=100; i++) {
			System.out.println(name+": "+i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class Test2 {

	public static void main(String[] args) {
//		Thread t1 = new Thread(Th("T1"));
//		t1.start();
//		t1.setPriority(10);
//		Thread t2 = new Thread(Th("T2"));
//		t2.start();
//		t1.setPriority(1);

	}

}
