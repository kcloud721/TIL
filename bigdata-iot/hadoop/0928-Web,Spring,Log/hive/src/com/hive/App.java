package com.hive;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import com.biz.CarStatus;


public class App {
	
	String url;
	
	public App() {
		
	}

	public void getData() {
		for(int i=1; i<60; i++) {
			Random r = new Random();
			double speed = r.nextInt(200);
			CarStatus cstatus = new CarStatus("car01", speed, 24, 90, 1500);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			try {
				sendData(cstatus);
				System.out.println("Send Data ...."+speed);
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
		}
	}
	
	public void sendData(CarStatus cs) throws Exception {
		url = "http://127.0.0.1/hive/carstatus.mc";	
		url += "?id="+cs.getId()+"&speed="+cs.getSpeed()+"&temp="+cs.getTemp()+
				"&oiltemp="+cs.getOiltemp()+"&rpm="+cs.getRpm();
		System.out.println(url);
		URL curl = new URL(url);
		HttpURLConnection con = (HttpURLConnection)curl.openConnection();
		con.setReadTimeout(5000);
		con.setRequestMethod("POST");
		con.disconnect();		
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.getData();
	}

}
