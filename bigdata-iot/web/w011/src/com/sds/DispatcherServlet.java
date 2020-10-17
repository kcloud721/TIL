package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet({ "/DispatcherServlet", "/dispatcher" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));	
		path = path.substring(1, path.lastIndexOf("."));
		//http://ssss.com/main.nhn -> substring -> "main" 
		
		String next = "main.jsp";
		if(path.equals("main")) {
			next = "main.jsp";
		}else if(path.equals("login")) {
			next = "main.jsp";
			request.setAttribute("centerpage", "login");
		}else if(path.equals("register")) {
			next = "main.jsp";
			request.setAttribute("centerpage", "register");
		}else if(path.equals("userlist")) {
			next = "userlist.jsp";
		}else if(path.equals("loginimpl")) {
			next = "loginimpl";		//call servlet not jsp
		}else if(path.equals("registerimpl")) {
			next = "main.jsp";
			request.setAttribute("centerpage", "registerok");
		}
		RequestDispatcher rd = 
			request.getRequestDispatcher(next);
			rd.forward(request, response);
		System.out.println("we go hundred "+path);
		
	}

}
