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
 * Servlet implementation class UserDetailServlet
 */
@WebServlet({ "/UserDetailServlet", "/userdetail" })
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserDetailServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		User user = null;
		Controller<String, User> controller = new UserController();
		try {
			user = controller.get(id);
			//System.out.println(user);
			request.setAttribute("userdetail", user);
			request.setAttribute("centerpage", "userdetail");
			
		} catch (Exception e) {
			System.out.println("user load Fail");
			e.printStackTrace();
		}
		RequestDispatcher rd = 
				request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
	}

}
