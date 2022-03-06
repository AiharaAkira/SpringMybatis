<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>메뉴번호</td>
		<td>메뉴명</td>
		<td>가격</td>
	</tr>
	<tr>
		<td>${menu123.m_no}</td>
		<td>${menu123.m_name}</td>
		<td>${menu123.m_price}</td>
	</tr>
</table>
	<button onclick="location.href='home'">홈으로</button>
</body>
</html>