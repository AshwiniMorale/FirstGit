package com.commons;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		  con = ConectionManager.getConnection();	
		  res.setContentType("text/html");
		  PrintWriter pw = res.getWriter();
			try {		

			String roll= req.getParameter("roll");
			int roll1 = Integer.parseInt(roll);
			PreparedStatement ps = con.prepareStatement("Delete from stud where roll=?;");
			ps.setInt(1, roll1);
			int c =ps.executeUpdate();
			if(c>0)
			{
				pw.print("delete sucessfully<br/>");
			}
			else
			{
				pw.print("row is not present<br/>");

			}
			pw.print("<a href='index.jsp'>home</a>");

		    }catch (SQLException e)
			{
		    	pw.print(e);
			}


	}

}
