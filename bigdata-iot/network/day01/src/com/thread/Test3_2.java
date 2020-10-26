package com.thread;

import java.util.Scanner;

class Thread11 implements Runnable{
	
	boolean flag = true;
	
	public Thread11() {}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	@Override
	public void run() {
		System.out.println("Start");
		while(true) {
			if(flag == false) {
				System.out.println("Stop...");
				break;
			}
			System.out.println("Connecting...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("End");
	}
	
}

public class Test3_2 {

	public static void main(String[] args) {
		Thread11 r = new Thread11();
		Thread t1 = null;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("input Cmd");
			String cmd = sc.nextLine();
			if(cmd.equals("start")) {
				t1 = new Thread(r);
				t1.start();
			}else if(cmd.equals("stop")) {
				r.setFlag(false);
			}else {
				break;
			}
		}
		sc.close();
		System.out.println("Exit App...");

	}

}
