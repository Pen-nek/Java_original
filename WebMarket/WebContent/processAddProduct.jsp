<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp"%>
<title> 상품 등록 </title>

<%
	request.setCharacterEncoding("UTF-8");

	String filename = "";
	String realFolder = "D:/GitHub/Java_original/WebMarket/WebContent/resources/images/";	//웹 앱 상의 절대 경로
	int maxSize = 5 * 1024 * 1024;	// 최대 업로드될 파일의 크기 5MB
	String encType = "utf-8";	// 인코딩 유형
	
	// new DefaultFileRenamePolicy() : 서버에 동일한 파일이 존재하면 전송된 파일명 뒤에 숫자를 덧붙여 파일명이 중복되지 않게 함
	MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType);

	String productId = multi.getParameter("productId");
	String name = multi.getParameter("name");
	String unitPrice = multi.getParameter("unitPrice");
	String description = multi.getParameter("description");
	String publisher = multi.getParameter("publisher");
	String category = multi.getParameter("category");
	String unitsInStock = multi.getParameter("unitsInStock");
	String condition = multi.getParameter("condition");

	Integer price;

	if (unitPrice.isEmpty())
		price = 0;
	else
		price = Integer.valueOf(unitPrice);

	long stock;

	if (unitsInStock.isEmpty())
		stock = 0;
	else
		stock = Long.valueOf(unitsInStock);
	
	Enumeration files = multi.getFileNames();
	String fname = (String) files.nextElement();
	String fileName = multi.getFilesystemName(fname);
	
	PreparedStatement pstmt = null;
	
	String sql = "insert into product values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	pstmt = conn.prepareStatement(sql);

	pstmt.setString(1, productId);
	pstmt.setString(2, name);
	pstmt.setInt(3, price);
	pstmt.setString(4, description);
	pstmt.setString(5, category);
	pstmt.setString(6, publisher);
	pstmt.setLong(7, stock);					// Long으로 들어가도 괜찮은지 확인
	pstmt.setString(8, condition);
	pstmt.setString(9, fileName);
	pstmt.executeUpdate();
	
	if (pstmt != null)
		pstmt.close();
	if (conn != null)
		conn.close();

	response.sendRedirect("products.jsp");
%>
