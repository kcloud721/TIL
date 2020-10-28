package com.tcpip;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	int port;
	String address;
	Socket socket;
	
	public Client() {}
	public Client(String address, int port) {
		this.address = address;
		this.port = port;
	}
	
	public void connect() throws InterruptedException {
		try {
			socket = new Socket(address, port);
			System.out.println("Connected...");
		} catch (Exception e) {
			e.printStackTrace();
			while(true) {
				Thread.sleep(2000);
				try {
					socket = new Socket(address, port);
					System.out.println("Connected2...");
					break;
				} catch (Exception e1) {
					System.out.println("Retry...");
				}

			}
		}
	}
	
	class Sender extends Thread{
		DataOutputStream dos;
		String msg;
		public Sender(String msg) {
			this.msg = msg;
			try {
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			if(dos != null) {
				try {
					dos.writeUTF(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void request() throws Exception {
		Scanner sc = new Scanner(System.in);
		try {
			while(true) {
				System.out.println("[Input msg]");
				String msg = sc.nextLine();
				if(msg.equals("q")) {
					new Sender("q").start();	
					//이거 없으면q 눌렀을 때 break가 걸려서 서버에서Exception error
					//"q"를 보내고 break 함으로써 q에 대한 메시지 처리 가능하게 
					Thread.sleep(1000);
					System.out.println("Exit Client..");
					break;
				}
				new Sender(msg).start();
			}
		} catch(Exception e) {
			
		} finally{
			sc.close();
			if(socket != null) {
				socket.close();
			}
		}
	}

	public static void main(String[] args) {
		Client client = new Client("192.168.1.22", 7777);
		try {
			client.connect();
			client.request();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
