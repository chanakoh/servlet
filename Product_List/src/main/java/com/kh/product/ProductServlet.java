package com.kh.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Product
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "KHCAFE";
	private static final String pw = "KHCAFE";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ ���̽� ����
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(jdbcURL, user, pw);
			String sql = "SELECT * FROM products";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			
			//��ǰ����� ������ ��ٱ��� ���� ArrayList����
			ArrayList<Product> productList = new ArrayList<>();
			
			while(resultSet.next()) {
				int productId = resultSet.getInt("product_id");
				String productName = resultSet.getString("product_name");
				String category = resultSet.getString("category");
				double price = resultSet.getDouble("price");
				int stockQuantity = resultSet.getInt("stock_quantity");
				
				Product product = new Product(productId, productName,category,price,stockQuantity);
				//productList:��ǰ���� �ϳ��� add�ؼ� �־���
				productList.add(product);
			}
			
			//JSP ��ǰ��� �������� ��ǰ ����� ��������!
			request.setAttribute("productList", productList);
			request.getRequestDispatcher("/productList/jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}