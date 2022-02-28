<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<form action="member.update" method="post" enctype="multipart/form-data" name="updateMemberForm" onsubmit="return updateMemberCheck();">
		<table id="joinTable">
			<tr>
				<td id="joinTableTitle" colspan="2" align="center">
					<input readonly="readonly" value="${sessionScope.loginMember.m_id }" name="jm_id" id="updateMemberIDInput" style="color:black;">
				</td>
			</tr>
			<tr>
				<td class="td1">PW</td>
				<td class="td2"><input value="${sessionScope.loginMember.m_pw }" name="jm_pw" placeholder="필수, 숫자 하나이상 반드시" type="password" maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td class="td1">PW확인</td>
				<td class="td2"><input value="${sessionScope.loginMember.m_pw }" name="jm_pwChk" placeholder="필수, 숫자 하나이상 반드시" type="password" maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td class="td1">이름</td>
				<td class="td2"><input value="${sessionScope.loginMember.m_name }" name="jm_name" placeholder="필수" maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td class="td1">주소</td>
				<td class="td2">
					<input id="jm_addr3Input" readonly="readonly" value="${addr[2] }"  name="jm_addr3" maxlength="5" autocomplete="off" placeholder="우편번호">
					<span id="addrSearchBtn">[검색]</span>
					<br>
					<input id="jm_addr1Input" readonly="readonly" value="${addr[0] }"  name="jm_addr1" maxlength="30" autocomplete="off" placeholder="주소"><br>
					<input value="${addr[1] }"  name="jm_addr2" maxlength="30" autocomplete="off" placeholder="상세주소">
				</td>
			</tr>
			<tr>
				<td class="td1">사진</td>
				<td class="td2">
					<img src="resources/file/${sessionScope.loginMember.m_photo }" id="updateMemberPhoto"><br>
					<input name="jm_photo" type="file">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="background-color: #FFFFFF;">
					<button>수정</button>
					<button onclick="bye();" type="button">탈퇴</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>








