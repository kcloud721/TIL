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

/**
 * Servlet implementation class UserUpdateServelet
 */
@WebServlet({ "/UserUpdateServelet", "/userupdate" })
public class UserUpdateServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Controller<String, User> controller;
	
    public UserUpdateServelet() {
        super();
        controller = new UserController();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User dbuser = null;
		
		try {
			dbuser = controller.get(id);
			request.setAttribute("userupdate", dbuser);
			request.setAttribute("centerpage", "userupdate");
		} catch (Exception e) {
			System.out.println("user load Fail");
			e.printStackTrace();
		}
		RequestDispatcher rd = 
				request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
		
	}

}
