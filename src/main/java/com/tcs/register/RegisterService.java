package com.tcs.register;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterService")
public class RegisterService extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterService() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String username = request.getParameter("username");		
		String password = request.getParameter("password");
		
		String[] qualification = request.getParameterValues("qualification");
		String gender = request.getParameter("gender");

		String[] technologies = request.getParameterValues("technologies");
		String country = request.getParameter("country");
		
		String[] addrs = request.getParameterValues("addr");
		String review = request.getParameter("review");
		
		//Conversion of String[] into StringBuffer(single object) format. 
		StringBuffer newquals = new StringBuffer();
		for(String qual : qualification)
		{	newquals.append(qual+",");
		}
		
		StringBuffer newtech = new StringBuffer();
		for(String tech : technologies)
		{	newtech.append(tech+",");
		}
		
		StringBuffer newaddrs = new StringBuffer();
		for(String addr : addrs)
		{	newaddrs.append(addr+",");
		}
	
		String finalQual = newquals.toString();
		String finalTech = newtech.toString();
		String finaladdrs =  newaddrs.toString();
		
		int count = UserDao.save(username, password, finalQual, gender, finalTech, country, finaladdrs, review);
		if(count==1)
		{	writer.println("Data inserted successfully....");
			writer.println("<br><br>");			
			writer.println("<a href='login.html'>Click here to login</a>");
		}
		else
		{	writer.println("Data not inserted Check once....");
		}
	}
}