package com.sds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.User;

/**
 * Servlet implementation class SelectAllServlet
 */
@WebServlet({ "/SelectAllServlet", "/selectall" })
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SelectAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Database에서 데이터를 가지고 온다.
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id01", "pwd01", "james1"));
		list.add(new User("id02", "pwd02", "james2"));
		list.add(new User("id03", "pwd03", "james3"));
		list.add(new User("id04", "pwd04", "james4"));
		list.add(new User("id05", "pwd05", "james5"));
		// 2. 가지고 온 데이터를 request 에 셋팅 한다.
		// 3. main 페이지로 이동한다.
		// 4. centerpage 를 셋팅한다.
		request.setAttribute("userlist", list);
		request.setAttribute("centerpage", "selectall");
		RequestDispatcher rd = 
		request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}
