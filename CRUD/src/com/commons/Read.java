package com.commons;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Read extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		Connection con = ConectionManager.getConnection();
		PrintWriter pw = res.getWriter();

		try {
			PreparedStatement ps = con.prepareStatement("select * from stud;");
			ResultSet rs = ps.executeQuery();
			 pw.println("Roll"+"\t"+"Name"+" \t "+"Marks" );
			 pw.print("<br/>");


			while(rs.next())
			{
			 pw.print(rs.getInt(1)+" \t"+rs.getString(2)+" \t "+rs.getInt(3)+"<br><br>");
			}
			
			pw.print("<a href='index.jsp'>home</a>");

		    }catch (SQLException e)
			{
		    	pw.print(e);
			}

	}

}
