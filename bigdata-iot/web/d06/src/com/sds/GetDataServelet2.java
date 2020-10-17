package com.sds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDataServelet2
 */
@WebServlet({ "/GetDataServelet2", "/getdata2" })
public class GetDataServelet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataServelet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("cmd");
		System.out.println(data);
		
//		Random r = new Random();
//		int num = r.nextInt(100)+1;
//		response.setContentType("text/html;charset=euc-kr");
//		PrintWriter out = response.getWriter();
//		out.print(data+" "+num);
	}

}
