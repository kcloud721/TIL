package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserController;
import frame.Controller;
import vo.User;

@WebServlet({ "/RegisterImplServlet", "/registerimpl" })
public class RegisterImplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterImplServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		System.out.println(id+" "+pwd+" "+name);
		User user = new User(id, pwd, name);
		
		Controller<String, User> controller = new UserController();
		try {
			controller.register(user);
			System.out.println("Register OK");
			request.setAttribute("registeruser", user);
			request.setAttribute("centerpage", "registerok");
		} catch (Exception e) {
			System.out.println("Register Fail");
			e.printStackTrace();
			request.setAttribute("centerpage", "registerfail");
		}
		
		RequestDispatcher rd = 
		request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}







