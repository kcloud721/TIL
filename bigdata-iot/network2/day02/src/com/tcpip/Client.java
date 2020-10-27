package com.tcpip;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	int port;
	String ip;
	Socket socket;
	
	OutputStreamWriter ow;
	BufferedWriter bw;
	
	public Client(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	public void connectServer() {
		try {
			System.out.println("Start Client");
			socket = new Socket(ip, port);
			System.out.println("Connected ... ");

		} catch (IOException e) {
			while(true) {
				try {
					Thread.sleep(2000);
					socket = new Socket(ip, port);
					System.out.println("Connected ... ");
					break;
				} catch (Exception e1) {
					System.out.println("Retry ... ");
				}
			}
		}
	}
	
	public void request(String msg) throws IOException {
		try {
			ow = new OutputStreamWriter(socket.getOutputStream());
			bw = new BufferedWriter(ow);
			bw.write(msg);
			bw.flush();
		} catch(Exception e) {
			throw e;
		} finally {
			if(bw != null)
				bw.close();
			if(socket != null)
				socket.close();
		}
	}
	
	public static void main(String[] args) {
		Client client = null;
		client = new Client("192.168.0.15", 9999);
		client.connectServer();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Input msg");
			String msg = sc.nextLine();
			if(msg.equals("q")) {		// q ÀÔ·Â ½Ã Å»Ãâ
				client.close();
				break;
			}
			
			try {
				client.request(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println("End Client");
	}
}
