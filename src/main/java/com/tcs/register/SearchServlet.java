package com.tcs.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		ResultSet set=UserDao.search(username,password);
		try {
		while(set.next())
		{
			writer.println(set.getString(1)+" <br><br> "+set.getString(2)+" <br><br> "+set.getString(3)+" <br><br>  "+set.getString(4)+" <br><br>  "+set.getString(5)+" <br><br>  "+set.getString(6)+" <br><br>  "+set.getString(7)+" <br><br>  "+set.getString(8));
			
		}
		}
		catch (Exception e) {
			
		}
	}

}
