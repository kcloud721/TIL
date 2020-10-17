package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

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
		
		Db<String,User> db = new UserDb("127.0.0.1", "db", "db");
		User user = null;
		try {
			user = db.select(id);
			System.out.println(user);
//			System.out.println(user.getName());
//			System.out.println(user.getPwd());
//			System.out.println(user.getId());
			
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		
		//System.out.println(id+" "+pwd);
		if(pwd.equals(user.getPwd())) {
			HttpSession session = request.getSession();
			System.out.println(session);
			session.setAttribute("suserid", id);	//permanent
			request.setAttribute("loginid", id);	//temporary
			request.setAttribute("centerpage", "loginok");
		}else {
			request.setAttribute("centerpage", "loginfail");
		}
		RequestDispatcher rd = 
		request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
		
	}

}




