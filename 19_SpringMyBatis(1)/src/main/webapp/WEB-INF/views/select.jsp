<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="m" items="${menus}">
		<h3>메뉴명:${m.m_name}</h3>
		<h3>메뉴가격:${m.m_price}</h3>
	</c:forEach>
</body>
</html>