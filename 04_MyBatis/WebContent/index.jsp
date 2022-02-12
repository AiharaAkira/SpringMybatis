<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<c:forEach var="p" items="${products}">

	<div>${p.p_no}</div>
	<div>${p.p_name}</div>
	<div>${p.p_price}</div>
	<div> <img src="img/${p.p_img}"></div>
	<div>${p.p_exp}</div>

</c:forEach>

<h3>품명으로 검색</h3>
<form action="SearchController">
품명:<input name="name">
<button>검색</button>
</form>

<h3>상품 등록</h3>
<form action="InsertController" method="post" enctype="multipart/form-data">
품명:<input name="name">
가격:<input name="price">
사진:<input name="img" type="file">
기간:<input name="exp" type="date">
<button>등록</button>
</form>

<h3>번호로 삭제</h3>
<form action="DeleteController">
품번:<input name="no">
<button>삭제</button>
</form>

<h3>가격으로 검색</h3>
<form action="SearchPriceController">
~이하 검색 :<input name="price">
<button>검색</button>
</form>

<h3>가격대 설정 검색</h3>
<!-- range price search -->
<form action="SearchTwoPriceController">
최소가격:<input name="price1">
최대가격:<input name="price2">
<button>검색</button>
</form>

<h3>가격 인상</h3>
<form action="UpdatePriceController">
~원이하:<input name="price1">
인상가:<input name="price2">
<button>인상</button>
</form>

</body>
</html>