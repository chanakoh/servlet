package com.kh.imageUpload;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String pw = "KHCAFE";
		
		String uname = request.getParameter("USER_NAME");
		String email = request.getParameter("EMAIL");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conn=DriverManager.getConnection(jdbcURL, user, pw);
			String sql = "UPDATE USERINFO SET USER_NAME =? WHERE USER ID=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,uname);
			ps.setString(2, email);
			int rowsUpdate = ps.executeUpdate();
			if(rowsUpdate.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
/*	try {
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			String updateQuery = "UPDATE BANK SET balance = ? WHERE account_number = ?";
			PreparedStatement updatePs = con.prepareStatement(updateQuery);
			updatePs.setDouble(1, 2000.00);
			updatePs.setString(2, "1234567890");
			int rowsUpdate = updatePs.executeUpdate();
			System.out.println(rowsUpdate + " ¾÷µ¥ÀÌÆ® µÇ¾ú½À´Ï´Ù.");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
