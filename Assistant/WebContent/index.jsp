<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.*"%>

<!-- https://codeday.me/ko/qa/20190307/16217.html -->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>The Assistant</title>
        <link rel="stylesheet" type="text/css" href="css/style.css?ver=21">
        <link rel="stylesheet" href="css/clndr.css">
        <style>
            #img_calendar {
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
                        <li id="img_calendar" class="tab"><img src="images/calendar.png" alt="달력"></li>
                        <li id="img_phone" class="tab">
                            <a href="contact.jsp"><img src="images/phone_w.png" alt="휴대폰"></a>
                        </li>
                    </ul>
                </nav>

                <div id="contents_wrapper">
                    <%@ include file="header.jsp" %>
                    
                    <!-- 콘텐츠 영역 -->
                    <div id="contents_index">
                    
                    	<!-- 캘린더 영역 -->
                    	<div id="calendar_div">
	                       	<div id="default" class="cal1"></div>
                       	</div>
                       	
                       	<!-- 할 일 영역 -->
						<div id="todo_div">
							<table id="tb_todo">
								<tr>
									<td class="tableTitle" colspan="2">
										<%
											SimpleDateFormat dateFormat = new SimpleDateFormat ( "yyyy년 MM월 dd일");
											Date day = new Date();
											String selectedDay = dateFormat.format(day);
										%>
										<%=selectedDay%>
									</td>
								</tr>
								
								<%@ include file="dbconn.jsp"%>
								<%
		                        	PreparedStatement pstmt = null;
		                        	ResultSet rs = null;
		                        	String sql = "select * from todo";
		                        	pstmt = conn.prepareStatement(sql);
		                        	rs = pstmt.executeQuery();
		                        	
		                        	while (rs.next()) {
		                        %>
								<tr id="todolist">
									<td id="check">
										<%
											if (rs.getInt("s_finished")==0) {
										%>
										<button class="checked_btn" onClick="Check(this.id)">
											<img src="images/checkbox_img.png">
										</button>
										<%
											} else {
										%>
										<button class="blank_btn" onClick="Check(this.id)">
											<img src="images/checked_img.png">
										</button>
										<%
											}
										%>
										
									</td>
									<td id="todo_td"><%=rs.getString("s_content") %></td>
								</tr>
								<%
		                        	}
		                        %>
							</table>
						</div>
		            </div>
				</div>
			</div>
		</div>
        
        <!-- 캘린더용 js -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore-min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.17.0/moment.min.js"></script>
        <script src="js/clndr.js"></script>
        <script src="js/calendar.js"></script>
        
        <!-- todolist 체크 js -->
        <script type="text/javascript">
        	function Check(btnClass) {
        		if (btnClass=="checked_btn")
        		document.getElementById("imageid").src="../template/save.png";
        	}
        </script>
    </body>
</html>
