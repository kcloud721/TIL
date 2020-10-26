package com.thread;

class Th1 extends Thread{
	int sum;
	@Override
	public void run() {
		for(int i=1; i<=20; i++) {
			System.out.println();
	
			sum += i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public int getSum() {
		return sum;
	}
	
}

class Th2 extends Thread{
	int sum;
	@Override
	public void run() {
		for(int i=1; i<=20; i++) {
			sum += i;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public int getSum() {
		return sum;
	}
	
}

public class Test5 {
	public static void main(String[] args) throws InterruptedException {
		Th1 th1 = new Th1();
		Th2 th2 = new Th2();
		System.out.println("START");
		
		th1.start();
		System.out.println("Th1 Started");
		
		th2.start();
		System.out.println("Th2 Started");

		th1.join();
		th2.join();
		
		System.out.println(th1.getSum()+" "+th2.getSum());
		System.out.println(th1.getSum()+th2.getSum());
	}
	
}
