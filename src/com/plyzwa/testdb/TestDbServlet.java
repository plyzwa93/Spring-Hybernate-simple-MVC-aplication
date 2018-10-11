package com.plyzwa.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Setup connection variables
			String user = "springstudent";
			String pass = "springstudent";
			String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL-false&serverTimezone=UTC";
			String driver = "com.mysql.jdbc.Driver";
		//Get connection Database
			try {
				PrintWriter out = response.getWriter();
				out.println("Conecting to the database:");
				out.println(jdbcUrl);
				
				Class.forName(driver);
				
				Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
				
				out.println("Everything is ok!!");
				
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
	}

}
