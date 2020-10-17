package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet({ "/DetailServlet", "/detail" })
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DetailServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		RequestDispatcher rd = 
			request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
	}

}
