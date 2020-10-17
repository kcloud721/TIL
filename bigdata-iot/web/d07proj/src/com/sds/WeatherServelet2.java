package com.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WeatherServelet2
 */
@WebServlet({ "/WeatherServelet2", "/weather2" })
public class WeatherServelet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlstr = "http://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa?serviceKey=V%2F%2F73TRbthIN%2B0xCCfSWBsd2zb6XDYRceQVGdmsV2Qz3E54ZmfRIuY6LS51e1E6L2KQUlGiGuh%2FDhYseyIDDeg%3D%3D&pageNo=1&numOfRows=10&dataType=XML&regId=11B10101&tmFc=202008140600&";
	       String xmlstr = getRequest(urlstr, "");
	       response.setContentType("text/xml;charset=euc-kr");
	       PrintWriter out = response.getWriter();
	       out.print(xmlstr);
	}
	
	public String getRequest(String url, String parameter) {
		try {
			String param = "{\"param\":\"" + parameter + "\"} ";
			URL uri = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			connection.setRequestMethod("GET");
			int code = connection.getResponseCode();
			if (code == 200) {
				try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
					String line;
					StringBuffer buffer = new StringBuffer();
					while ((line = input.readLine()) != null) {
						buffer.append(line);
					}
					return buffer.toString();
				}
			}
			return code + "";
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}
