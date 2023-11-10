<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "com.kh.product.Product" %>
    <%@ page import = "com.kh.product.ProductDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>제품 상세페이지</title>
</head>
<body>
<h1>제품 상세 정보</h1>
<%
	//String = id값을 가지고 오겠다.
	String productIdValue = request.getParameter("productId");
System.out.println(productIdValue);
	int productId = Integer.parseInt(productIdValue);
	System.out.println(productId);
//DAO작업
	ProductDAO productDAO = new ProductDAO();
	Product product = productDAO.getProductId(productId);
	System.out.println(product);
%>
<p>제품 ID:<%= product.getProductId() %></p>
<p>제품 이름:<%= product.getProductName() %></p>
<p>제품 카테고리:<%= product.getCategory() %></p>
<p>제품 가격:<%= product.getPrice() %></p>
<p>제품 재고:<%= product.getStockQuantity() %></p>


</body>
</html>

