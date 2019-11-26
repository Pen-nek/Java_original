<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>


<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1"
		charset="utf-8">
	<title>The Assistant</title>
	<link rel="stylesheet" type="text/css" href="css/style.css?ver=8">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	
	<style>
		#img_phone {
			background-color: white;
			cursor: pointer;
		}
	</style>
</head>

<body>
	<div>
		<div id="wrapper">
			<nav>
				<ul>
					<a href="index.jsp">
						<li id="img_calendar" class="tab"><img src="images/calendar_w.png"
							alt="달력"></li>
					</a>
					<li id="img_phone" class="tab"><img src="images/phone.png"
						alt="휴대폰"></li>
				</ul>
			</nav>

			<div id="contents_wrapper">
				<%@ include file="header.jsp"%>
				
				<div id="align">
				</div>
				
				<div id="contents">
					<table id="tb_contact">
						<tr>
							<td class="tableTitle">순번</td>
							<td class="tableTitle">이름</td>
							<td class="tableTitle">소속</td>
							<td class="tableTitle">연락처</td>
							<td class="tableTitle">메모</td>
							<td class="tableTitle">연락횟수</td>
						</tr>

							<%@ include file="dbconn.jsp"%>
							<%
	                        	PreparedStatement pstmt = null;
	                        	ResultSet rs = null;
	                        	String sql = "select * from contact";
	                        	pstmt = conn.prepareStatement(sql);
	                        	rs = pstmt.executeQuery();
	                        	while (rs.next()) {
	                        %>
						
						<tr id="contactlist">
							<td><%=rs.getInt("c_id") %></td>
							<td><%=rs.getString("c_name") %></td>
							<td><%=rs.getString("c_group") %></td>
							<td><%=rs.getString("c_phone") %></td>
							<td><%=rs.getString("c_memo") %></td>
							<td><%=rs.getInt("c_callcnt") %>회</td>
						</tr>
							<%
	                        	}
	                        %>
					</table>
					
						<table width="60%" id="addNsearch">
							<tr>
								<td align="left">
									<button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-black">추가</button>
								</td>
								<td align="right">
									<form id="searchContact" action="searchContact.jsp" method="get">	<!-- get으로 가져와도 되나? -->
										<input type="text" name="searchWord">
										<input type="submit" value="검색">
									</form>
								</td>
							</tr>
						</table>
					
				</div>
			</div>
		</div>
	</div>

	<!-- 연락처 추가 모달 -->
	<%@ include file="addContact.jsp"%>
	
</body>
</html>
