package com.tcs.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String check=UserDao.loginCheck(username,password);
		writer.println(check);
			if(check.equals("success"))
			{
				writer.println("Your login is success : <a href='http://www.fb.com'>click here to get the facebook</a>");
			}
			else {
				writer.println("username or password is incorrect");
			}
	}

}
