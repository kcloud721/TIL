package com.sds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.UserController;
import frame.Controller;
import vo.User;

@WebServlet({ "/LoginImplServlet", "/loginimpl" })
public class LoginImplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginImplServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// DB Matching
		
		User user = null;
		Controller<String, User> controller = new UserController();
		try {
			user = controller.get(id);
			// System.out.println(user);
		} catch (Exception e) {
			System.out.println("Select Fail");
			e.printStackTrace();
		}
		
		if(pwd.equals(user.getPwd())) {
			HttpSession session = request.getSession();
			
			System.out.println(session.toString());
			User u = new User(id, pwd, "");
			session.setAttribute("loginuser", u);
			request.setAttribute("centerpage", "loginok");
		}else {
			request.setAttribute("centerpage", "loginfail");
		}
		RequestDispatcher rd = 
		request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
		
	}

}




