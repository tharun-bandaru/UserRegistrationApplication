package com.tcs.register;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		boolean status=UserDao.delete(username,password);
		if(status)
		{
		  
		  RequestDispatcher dispatcher = request.getRequestDispatcher("del.html");
	      dispatcher.include(request, response);
		}
		else {
			  RequestDispatcher dispatcher = request.getRequestDispatcher("delete.html");
	 	      dispatcher.include(request, response);
		}
	}

}
