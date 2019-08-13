<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {border-collapse: collapse;}
</style>
</head>
<body>
	<h1>이혜민</h1>
	<form method='post' action='Ex0801_03.jsp'>	<!-- jsp에서 html 문법을 쓸 땐 '' 사용--> 
		<table border='1'>
			<tr>
				<td width='100'>제목</td>
				<td width='400'><input type='text' name='subject'></td>
			</tr>
			
			<tr>
				<td width='100'>이름</td>
				<td width='400'><input type='text' name='uname'></td>
			</tr>
			
			<tr>
				<td width='100'>통신사</td>
				<td width='400'>
					SKT : <input type='radio' name='phone' value='SKT' checked>
					KTF : <input type='radio' name='phone' value='KTF'>
					LG : <input type='radio' name='phone' value='LG'>
				</td>
			</tr>
			
			<tr>
				<td width='100'>지역</td>
				<td width='400'>
					<select name='region'>
						<option value='choose' selected>-- 선택  --</option>
						<option value='chungbuk'>충북</option>
						<option value='gyunggi'>경기</option>
						<option value='seoul'>서울</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td width='100'>텍스트</td>
				<td width='400'><textarea rows='15' cols='40' name='contents'></textarea></td>
			</tr>
			
			<tr>
				<td colspan='2' width='400'><input type='submit'></td>
			</tr>		
		</table>
	</form>
</body>
</html>