<%@ page import="java.sql.*" import="com.tcs.register.UserDao" %>

<HTML>
      
       <HEAD>
       <TITLE>*******ALL USERS*******</TITLE>
        </HEAD>
       <BODY bgcolor="cyan" >
        <style>
       TABLE{
       border: 1px solid;
       border-collapse: collapse;
        width: 100%;
         text-align: center;

        }
        th, td {
  		border-bottom: 1px solid #ddd;
  		font-size: 25px
		}
		tr:hover {background-color: coral;}	
	</style>
       <font color="red"><center><H1>*****ALL USERS***** </H1></center></font>
       <%
       	ResultSet resultset=UserDao.allUsers();
		
       %>
      <TABLE BORDER="1">
      <TR>
      <TH>User Name</TH>
      <TH>User Password</TH>
      <TH>Qualification</TH>
      <TH>Gender</TH>
      <TH>Technologies</TH>
      <TH>Country Name</TH>
      <TH>Address</TH>
      <TH>Comments</TH>
      
      </TR>
      <% while(resultset.next()){ %>
      <TR>
       <TD> <%= resultset.getString(1) %></td>
       <TD> <%= resultset.getString(2) %></TD>
       <TD> <%= resultset.getString(3) %></TD>
       <TD> <%= resultset.getString(4) %></TD>
       <TD> <%= resultset.getString(5) %></TD>
       <TD> <%= resultset.getString(6) %></TD>
       <TD> <%= resultset.getString(7) %></TD>
       <TD> <%= resultset.getString(8) %></TD>
	
      </TR>
      <% } %>
     </TABLE>
     </BODY>
</HTML>
