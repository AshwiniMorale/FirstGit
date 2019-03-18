package com.commons;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		  con = ConectionManager.getConnection();	
		  res.setContentType("text/html");
		  PrintWriter pw = res.getWriter();
			try {		

			String name= req.getParameter("name");
			String marks = req.getParameter("marks");
			int marks1 = Integer.parseInt(marks);
			PreparedStatement ps = con.prepareStatement("insert into stud(name,marks) values(?,?)");
			ps.setString(1, name);
			ps.setInt(2, marks1);
			ps.executeUpdate();
			pw.print("insert sucessfully<br>");
			pw.print("<a href='index.jsp'>home</a>");
		    }catch (SQLException e)
			{
		    	pw.print(e);
			}


	}

}
