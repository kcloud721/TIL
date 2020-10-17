package com.sds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Db<String,User> db;
    public LoginServlet() {
        super();
        db = new UserDb("127.0.0.1", "db", "db");
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		User dbuser = null;
		String flag = "f";
		try {
			dbuser = db.select(id);
			if(dbuser.getPwd().equals(pwd)) {
				flag = "o";
			}else {
				flag = "f";
			}
		} catch (Exception e) {
			flag = "f";
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter();
		out.print(id+ "welcome");
		
		
	}

}
