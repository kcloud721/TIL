package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

@WebServlet({ "/RegisterImplServlet", "/registerimpl" })
public class RegisterImplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterImplServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		System.out.println(id+" "+pwd+" "+name);
		
		Db<String,User> db = new UserDb("127.0.0.1", "db", "db");
		User user = new User(id, pwd, name);
		
		try {
			db.insert(user);
			System.out.println("Register OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		
		request.setAttribute("registeruser", user);
		request.setAttribute("centerpage", "registerok");
		
		RequestDispatcher rd = 
		request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}







