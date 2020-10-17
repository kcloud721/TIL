package com.sds;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResigerServlet2
 */
@WebServlet("/register")
public class ResigerServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResigerServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("t1");
		String pwd = request.getParameter("p1");
		String radio = request.getParameter("r1");
		String[] check = request.getParameterValues("c1");
		String id = request.getParameter("id");
		
		System.out.println(id);
		System.out.println(text+" "+pwd+" "+radio+" "+check);
		System.out.println(Arrays.toString(check));
		
		
//		if(id.equals("id00")) {
//			response.sendRedirect("a3.html");
//		} else {
//			response.sendRedirect("a2.html");
//		}
//		response.sendRedirect("a5.html");
	}

}
