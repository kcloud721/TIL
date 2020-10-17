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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class GetDataServelet4
 */
@WebServlet({ "/GetDataServelet4", "/getdata4" })
public class GetDataServelet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataServelet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 1. import jsonData
		String orders = request.getParameter("jsonData");
		System.out.println(orders);
		
		// 2. db to JSON
		/*
		JSONArray ja = new JSONArray();
		ArrayList<Hamburger> list = new ArrayList<>();
		for(Hamburger u:list) {
			JSONObject obj = new JSONObject();
			obj.put("id", u.getId());
			obj.put("cnt", u.getCnt());
			ja.add(obj);
		}
		*/
		
		// 2-2. json parse
		JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try {
        	obj = (JSONObject)parser.parse(orders);  		
        } catch (ParseException e) {
             System.out.println("변환에 실패");
             e.printStackTrace();
        }
        System.out.println(obj);
        System.out.println(obj.get("001"));
        System.out.println(obj.get("002"));
        System.out.println(obj.get("003"));
        
		
		// 3. reponse 	
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(orders);
		
	}

}
