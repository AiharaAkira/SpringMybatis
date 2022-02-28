<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>조회 결과</h1>
	이름:${student.n}
	평점:<fmt:formatNumber value="${student.avg}" pattern=".0" /> 
	등급:${student.grade}
	
	<hr>
</body>
</html>