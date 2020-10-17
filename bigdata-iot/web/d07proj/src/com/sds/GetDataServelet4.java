package com.sds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class GetDataServelet4
 */
@WebServlet({ "/GetDataServelet4", "/getdata4" })
public class GetDataServelet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Hamburger> list = new ArrayList<>();
//		������ ���̵�, �̸�, ����, ����
		list.add(new Hamburger("001", "hamburger1", 10000, 10));
		list.add(new Hamburger("002", "hamburger2", 20000, 20));
		list.add(new Hamburger("003", "hamburger3", 30000, 30));
		list.add(new Hamburger("004", "hamburger4", 40000, 40));
		list.add(new Hamburger("005", "hamburger5", 50000, 50));
		
		JSONArray ja = new JSONArray();
		for(Hamburger h: list) {
			JSONObject obj = new JSONObject();
			obj.put("id", h.getId());
			obj.put("name", h.getName());
			obj.put("price", h.getPrice());
			obj.put("stock", h.getStock());
			ja.add(obj);
		}
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());
	}

}
