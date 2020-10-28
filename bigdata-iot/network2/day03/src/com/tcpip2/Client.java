package com.tcpip2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.msg.Msg;

public class Client {
	int port;
	String address;
	Socket socket;
	Sender sender;
	
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
		sender = new Sender();
	}
	
	class Sender implements Runnable{
		ObjectOutputStream dos;
		Msg mo;
		public void setMo(Msg mo) {
			this.mo = mo;
		}
		public Sender() {
			try {
				dos = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			if(dos != null) {
				try {
					dos.writeObject(mo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void request() throws Exception {
		Scanner sc = new Scanner(System.in);
		try {
			Msg mo = null;
			while(true) {
				System.out.println("[Input msg]");
				String msg = sc.nextLine();
				mo = new Msg("192.168.1.22", "[jean]", msg.trim());
				sender.setMo(mo);
				new Thread(sender).start();
				Thread.sleep(1000);

				System.out.println("input: "+mo);
				if(msg.equals("q")) {
					System.out.println("Exit Client..");
					break;
				}
				
				Thread.sleep(500);
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
