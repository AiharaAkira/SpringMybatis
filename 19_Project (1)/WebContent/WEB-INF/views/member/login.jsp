<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="member.login" method="post" name="loginForm">
		<table id="loginTable">
			<tr>
				<td align="center"><input name="m_id" placeholder="ID"
					maxlength="15" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><input name="m_pw" placeholder="PW"
					maxlength="15" autocomplete="off" type="password"></td>
			</tr>
			<tr>
				<td align="center"><button>로그인</button> &nbsp;&nbsp;
						<button type="button" onclick="goJoin()">회원가입</button></td>
			</tr>
		</table>
	</form>
</body>
</html>