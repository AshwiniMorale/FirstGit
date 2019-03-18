package com.commons;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CRUDoperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con= null;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
	  con = ConectionManager.getConnection();	
	  res.setContentType("text/html");
	  PrintWriter pw = res.getWriter();
	  String b2 = req.getParameter("button2");
	  String b3 = req.getParameter("button3");
	  String b4 = req.getParameter("button4");
	  String b5 = req.getParameter("button5");


	   if("Insert".equals(b2))
	   {
		 RequestDispatcher rd = req.getRequestDispatcher("/insert.jsp");
	   	 rd.forward(req, res);
	   }
	  else if("Read".equals(b3))
	  {
			 RequestDispatcher rd = req.getRequestDispatcher("Read");
		   	 rd.forward(req, res);
	  }
	  else if("Update".equals(b4))
	  {
			 RequestDispatcher rd = req.getRequestDispatcher("/update.jsp");
		   	 rd.forward(req, res);
	  }
	  else if("Delete".equals(b5))
	  {
		  RequestDispatcher rd = req.getRequestDispatcher("/delete.jsp");
		  rd.forward(req, res);
	  }
 }

}
