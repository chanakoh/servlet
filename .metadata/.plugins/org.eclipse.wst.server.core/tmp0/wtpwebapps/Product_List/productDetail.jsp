<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "com.kh.product.Product" %>
    <%@ page import = "com.kh.product.ProductDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ ��������</title>
</head>
<body>
<h1>��ǰ �� ����</h1>
<%
	//String = id���� ������ ���ڴ�.
	String productIdValue = request.getParameter("productId");
System.out.println(productIdValue);
	int productId = Integer.parseInt(productIdValue);
	System.out.println(productId);
//DAO�۾�
	ProductDAO productDAO = new ProductDAO();
	Product product = productDAO.getProductId(productId);
	System.out.println(product);
%>
<p>��ǰ ID:<%= product.getProductId() %></p>
<p>��ǰ �̸�:<%= product.getProductName() %></p>
<p>��ǰ ī�װ�:<%= product.getCategory() %></p>
<p>��ǰ ����:<%= product.getPrice() %></p>
<p>��ǰ ���:<%= product.getStockQuantity() %></p>


</body>
</html>

