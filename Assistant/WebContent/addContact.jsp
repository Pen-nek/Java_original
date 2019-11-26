<!-- include 시 한글 깨짐 방지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="w3-container" >		
	<div id="id01" class="w3-modal" >
	<div class="w3-modal-content">
      <div class="w3-container">
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright"> &times;</span>

		<form id="modal" action="processAddContact.jsp" method="post">
			<h2 width="100px">연락처 추가</h2>
			<table id="tb_modal">
				<tr>
					<td>
						<label>이름</label>
					</td>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<td>
						<label>소속</label>
					</td>
					<td>
						<input type="text" name="group">
					</td>
				</tr>
				<tr>
					<td>
						<label>연락처</label>
					</td>
					<td>
						<input type="text" name="phone">
					</td>
				</tr>
				<tr>
					<td>
						<label>메모</label>
					</td>
					<td>
						<textarea name="memo"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="완료">
					</td>
				</tr>
			</table>
		</form>
      </div>
    </div>
  </div>
</div>

