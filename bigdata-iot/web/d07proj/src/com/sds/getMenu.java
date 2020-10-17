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
 * Servlet implementation class getMapData
 */
@WebServlet("/getMenu")
public class getMenu extends HttpServlet {
	
	JSONArray ja = new JSONArray();
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Menu> list = new ArrayList<>();
		
		if (ja.size() < 5) {
			list.add(new Menu("001", "Burger1", 10000, 100));
			list.add(new Menu("002", "Burger2", 20000, 10));
			list.add(new Menu("003", "Burger3", 30000, 10));
			list.add(new Menu("004", "Burger4", 40000, 10));
			list.add(new Menu("005", "Burger5", 50000, 10));
		}
		for(Menu m:list) {
			JSONObject obj = new JSONObject();
			obj.put("id", m.getId());
			obj.put("name", m.getName());
			obj.put("price", m.getPrice());
			obj.put("stock", m.getStock());
			ja.add(obj);
		}
		
		String data = request.getParameter("order");
		
		System.out.println(data);
		
		if (data != null) {
			int order_id = Integer.parseInt(data.substring(0,data.indexOf('&'))) - 1;
			int order_stock = Integer.parseInt(data.substring(data.indexOf('&') + 1));
			JSONObject obj = new JSONObject();
			obj = (JSONObject) ja.get(order_id);
			int origin_stock = (int) obj.get("stock");
			
			if (origin_stock < order_stock) {
				return;
			}
			obj.put("stock", origin_stock - order_stock);
		}
		

		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());
	}
}