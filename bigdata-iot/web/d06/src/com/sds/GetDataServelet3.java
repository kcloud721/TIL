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
 * Servlet implementation class GetDataServelet3
 */
@WebServlet({ "/GetDataServelet3", "/getdata3" })
public class GetDataServelet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. import db
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id01", "pwd01", "햄버거"));
		list.add(new User("id02", "pwd02", "트레이"));
		list.add(new User("id03", "pwd03", "후렌치"));
		list.add(new User("id04", "pwd04", "후라이"));
		list.add(new User("id05", "pwd05", "제로콕"));
		
		// 2. db to JSON
//		JSONArray ja = new JSONArray();
//		JSONObject jo1 = new JSONObject();
//		jo1.put("id", "id01");
//		jo1.put("pwd", "pwd01");
//		jo1.put("name", "햄버거");
//		ja.add(jo1);	//[{id01}, {pwd01}, {햄버거}]
		
		JSONArray ja = new JSONArray();
		for(User u:list) {
			JSONObject obj = new JSONObject();
			obj.put("id", u.getId());
			obj.put("pwd", u.getPwd());
			obj.put("name", u.getName());
			ja.add(obj);
		} 
		
		// 3. response JSON
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());
	}

}
