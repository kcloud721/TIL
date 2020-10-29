package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.msg.Msg;

public class Client {
	int port;
	String address;
	String id;
	Socket socket;
	Sender sender;
	
	public Client() {}
	public Client(String address, int port, String id) {
		this.port = port;
		this.address = address;
		this.id = id;
	}
	
	public void connect() throws IOException {
		try {
			socket = new Socket(address, port);
		} catch (Exception e) {
			while(true) {
				try {
					Thread.sleep(2000);
					socket = new Socket(address, port);
					break;
				} catch (Exception e1) {
					System.out.println("Retry");
				}
			}
		}
		System.out.println("Connected Server!! "+address);
		sender = new Sender(socket);
		new Receiver(socket).start();
	}
	
	public void sendMsg() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Input MSG: ");
			String ms = sc.nextLine();
			Msg msg = new Msg("", id, ms);
			sender.setMsg(msg);
			new Thread(sender).start();
			if(ms.contentEquals("q")) {
				break;
			}
			
		}
		sc.close();
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("BYEBYE~");
	}
	
	class Sender implements Runnable{
		Socket socket;
		ObjectOutputStream oo;
		Msg msg;
		public Sender(Socket socket) throws IOException {
			this.socket = socket;
			oo = new ObjectOutputStream(socket.getOutputStream());
		}
		public void setMsg(Msg msg) {
			this.msg = msg;
		}
		@Override
		public void run() {
			if(oo != null) {
				try {
					oo.writeObject(msg);
				} catch (IOException e) {
//					e.printStackTrace();
					try {
						if(socket != null)
							socket.close();
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					try {		// retry 
						Thread.sleep(2000);
						connect();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
	
	class Receiver extends Thread{	// 서버에서 보낸 매시지를 받음 
		Socket socket;
		ObjectInputStream oi;
		public Receiver(Socket socket) throws IOException {
			oi = new ObjectInputStream(socket.getInputStream());
		}
		@Override
		public void run() {
			while(oi != null) {
				Msg msg = null;
				try {
					msg = (Msg) oi.readObject();
					System.out.println(msg.getId()+" "+msg.getMsg());
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}	//end while
			try {
				if(oi != null)
					oi.close();
				if(socket != null)
					socket.close();
			} catch(Exception e) {
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		Client client = new Client("192.168.0.6", 5555, "ㄴ(°0°)ㄱ  ");
		try {
			client.connect();
			client.sendMsg();
		} catch (Exception e) {
			
		}
	}
}
