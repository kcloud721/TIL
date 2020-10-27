package com.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test4 {

	public static void main(String[] args) {
		String urlstr = "http://192.168.0.15/network/login.jsp";
		URL url = null;
		HttpURLConnection con = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String str = "";
		boolean flag = false ;

		try {
			String id = "qqq";
			String pwd = "111";
			url = new URL(urlstr + "?id=" + id + "&pwd=" + pwd);
			con = (HttpURLConnection) url.openConnection();
			con.setReadTimeout(5000);
			con.setRequestMethod("POST");

			isr = new InputStreamReader(con.getInputStream(), "UTF-8");
			br = new BufferedReader(isr);
			
			while((str = br.readLine()) != null) {
				System.out.println(str.trim());
				if(str.equals("1"))
					flag = true;
			}


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			con.disconnect();
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(flag == true) {
			System.out.println("login success");
		} else {
			System.out.println("login failed");
		}


	}

}
