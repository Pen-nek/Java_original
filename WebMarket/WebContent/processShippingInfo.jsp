<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ include file="dbconn.jsp" %>


<%
	request.setCharacterEncoding("UTF-8");

	Cookie cartId = new Cookie("Shipping_cartId", URLEncoder.encode(request.getParameter("cartId"), "utf-8"));
	Cookie name = new Cookie("Shipping_name", URLEncoder.encode(request.getParameter("name"), "utf-8"));
	Cookie shippingDate = new Cookie("Shipping_shippingDate", URLEncoder.encode(request.getParameter("shippingDate"), "utf-8"));
	Cookie country = new Cookie("Shipping_country", URLEncoder.encode(request.getParameter("country"), "utf-8"));
	Cookie zipCode = new Cookie("Shipping_zipCode", URLEncoder.encode(request.getParameter("zipCode"), "utf-8"));
	Cookie addressName = new Cookie("Shipping_addressName", URLEncoder.encode(request.getParameter("addressName"), "utf-8"));
	
	cartId.setMaxAge(24 * 60 * 60);
	name.setMaxAge(24 * 60 * 60);	
	shippingDate.setMaxAge(24 * 60 * 60);	// 책에서 shippingDate는 일부러 뺀 건가? 일단 넣어봄.
	zipCode.setMaxAge(24 * 60 * 60);
	country.setMaxAge(24 * 60 * 60);
	addressName.setMaxAge(24 * 60 * 60);
	
	
	// 쿠키 더하기
	response.addCookie(cartId);
	response.addCookie(name);
	response.addCookie(shippingDate);
	response.addCookie(country);
	response.addCookie(zipCode);
	response.addCookie(addressName);
	
	
/* 	// 상품 구매 시 장바구니에 있는 상품들 db의 재고 차감
	
		// 0. SQL구문 준비
	PreparedStatement pstmt = null;
	String sql = "UPDATE product SET p_unitsinstock = p_unitsinstock-? WHERE p_id=?";
	
		// 1. 장바구니 상품 배열 갖고오기 (id와 unitsInStock 필요)
	
		
		// 2. while 루프로 상품들의 재고 차감
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, );
	pstmt.setString(2, id);
	int rs = pstmt.executeUpdate();
	
	// pstmt.close(); 
	 */
	
	// 주문완료 페이지로 리다이렉트
	response.sendRedirect("orderConfirmation.jsp");

	
%>