package com.tcpip;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port;
	ServerSocket serverSocket;
	Socket socket;
	
	public Server()	{}
	public Server(int port) {
		this.port = port;
	}
	class Receiver extends Thread {
		DataInputStream dis;
		Socket socket = null;
		
		public Receiver(Socket socket) {
			this.socket = socket;
			try {
				// 서버에 파이프가 여러개 생김 
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while(dis != null) {
				String msg = "";
				try {
					msg = dis.readUTF();	// 여기서 대기 
					if(msg.equals("q")) {
						System.out.println("ㅇㅇ가 나갔습니다.");
						break;
					}
					System.out.println(msg);
				} catch (IOException e) {
					System.out.println("ㅇㅇ가 강제종료 .");
					break;
				}
				
			}
			if(dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public void startServer() throws Exception {
		System.out.println("TCP/IP Server Start");
		try {
			serverSocket = new ServerSocket(port);
			while(true) {
				System.out.println("Ready Server...");
				socket = serverSocket.accept();
				System.out.println("Connected");
				new Receiver(socket).start();
			}

		}catch(Exception e) {
			throw e;
		}
		
	}

	public static void main(String[] args) {
		Server server = new Server(7777);
		try {
			server.startServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
