package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.msg.Msg;

public class Server {
	int port;
	HashMap<String, ObjectOutputStream> maps;
	
	ServerSocket serverSocket;
	Receiver receiver;
	
	public Server() {}
	public Server(int port) {
		this.port = port;
		maps = new HashMap<>();
	}
	
	public void startServer() throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("Start Server!!!");
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				while(true) {	//아래 명령에서 exception 떨어져도 서버 종료되지 않고 계속 살아있음
					try {
						Socket socket = null;
						System.out.println("Ready Server...");
						socket = serverSocket.accept();
						System.out.println(socket.getInetAddress());
						makeOut(socket);
						new Receiver(socket).start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		new Thread(r).start();
		
	}
	
	public void makeOut(Socket socket) throws IOException {	// put into hashMap
		ObjectOutputStream oo;
		oo = new ObjectOutputStream(socket.getOutputStream());
		maps.put(socket.getInetAddress().toString(), oo);
		System.out.println("접속자 수 : "+maps.size());
	}
	
	class Receiver extends Thread{
		Socket socket;
		ObjectInputStream oi;
		public Receiver(Socket socket) throws IOException {
			this.socket = socket;
//			System.out.println(socket.getInputStream());
			oi = new ObjectInputStream(socket.getInputStream());
		}
		
		@Override
		public void run() {
			while(oi != null) {
				Msg msg = null;
				try {
					msg = (Msg) oi.readObject();
					if(msg.getMsg().contentEquals("q")) {
						throw new Exception();	// 강제로 익셉션 발생 시켜서 65라인 진입 .. 코드 중복 방지
					}
					sendMsg(msg);	// 모든 클라이언트에 메시지 전송 
					System.out.println(msg.getId()+" "+msg.getMsg());
				} catch (Exception e) {
					// 클라이언트가 없어진 경우 : 더이상 서버에서 클라이언트 정보를 갖고있읖 필요가 없음
					maps.remove(socket.getInetAddress().toString());	// 정보 삭제
					System.out.println(socket.getInetAddress()+" .. Exited");
					System.out.println("접속자 수 : "+maps.size());
					break;
				}
			}		// end while
			
			try {	// close all
				if(oi != null)
					oi.close();
				if(socket != null)
					socket.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	public void sendMsg(Msg msg) {
		Sender sender = new Sender();
		sender.setMsg(msg);
		sender.start();
	}
	
	class Sender extends Thread{	// hashMap �� ��Ƽ� ����
		Msg msg;
		public void setMsg(Msg msg) {
			this.msg = msg;
		}
		@Override
		public void run() {
			Collection<ObjectOutputStream> cols = maps.values();
			Iterator<ObjectOutputStream> it = cols.iterator();
			while(it.hasNext()) {
				try {
					it.next().writeObject(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Server server = new Server(5555);
		try {
			server.startServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
