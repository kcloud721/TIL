package com.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test3 {

	public static void main(String[] args) {
		String urlstr = "http://192.168.0.6/tcpip/car.jsp";
		URL url = null;
		HttpURLConnection con = null;
		
		while(true){
			try {
				double lat = Math.random()*90 + 127;
				double lng = Math.random()*90 + 32;
				url = new URL(urlstr+"?lat="+lat+"&lng="+lng);
				con = (HttpURLConnection) url.openConnection();
				con.setReadTimeout(5000);
				con.setRequestMethod("POST");
				con.getInputStream();
	
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				con.disconnect();
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		
	}

}
