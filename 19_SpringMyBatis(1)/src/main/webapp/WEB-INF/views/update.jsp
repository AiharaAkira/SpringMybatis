<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="menu.modi.do">
		메뉴가격:<input name="m_price">
		<!--  input type="hidden" value="${param.m_no}" name="m_no"-->
		<button value="${param.m_no}" name="m_no">수정</button>
	</form>

</body>
</html>