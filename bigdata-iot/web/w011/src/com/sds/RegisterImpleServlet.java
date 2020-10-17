package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.User;

/**
 * Servlet implementation class RegisterImpleServlet
 */
@WebServlet({ "/RegisterImpleServlet", "/registerimpl" })
public class RegisterImpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterImpleServlet() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
    	String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		System.out.println(id+" "+pwd+" "+name);
		
		User user = new User(id, pwd, name);
		
		request.setAttribute("registeruser", user); //set
		request.setAttribute("centerpage", "register ok");
		RequestDispatcher rd = 
				request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
		
	}
}
