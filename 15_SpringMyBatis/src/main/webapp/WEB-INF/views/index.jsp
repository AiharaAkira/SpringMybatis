<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td>상품번호</td>
			<td>사진</td>
			<td>품명</td>
			<td>가격</td>
			<td>유통기한</td>
		</tr>

		<c:forEach var="p" items="${products }">
			<tr>
				<td>${p.p_no }</td>
				<td><img src="resources/file/${p.p_img }" width="50px"
					height="50px"></td>
				<td>${p.p_name }</td>
				<td><fmt:formatNumber value="${p.p_price }" type="currency" />
				</td>
				<td><fmt:formatDate value="${p.p_exp }" dateStyle="short" /></td>
			</tr>
		</c:forEach>

	</table>

	<h1>상품등록</h1>

	<form action="reg.product" enctype="multipart/form-data" method="post">
		품명:<input name="p_name"><br> 사진:<input name="p_img"
			type="file"><br> 가격:<input name="p_price"><br>
		유통기한:<input name="p_exp" type="date"><br>
		<button>등록</button>
	</form>

	<h1>상품삭제</h1>
	<form action="del.product">
		품번:<input name="p_no"><br>
		<button>삭제</button>
	</form>

	<h1>품명검색(포함검색처리)</h1>
	<form action="search.productByName">
		품명:<input name="p_name"><br>
		<button>검색</button>
	</form>
	
	<h1>가격이하검색</h1>
	<form action="search.productByLowerPrice">
		~원 이하:<input name="p_price"><br>
		<button>검색</button>
	</form>
	
	<h1>가격대설정검색</h1>
	<form action="search.productByRange"><!-- map or 객체:정수2개품을생각(mapper.xml) -->
		최소가격:<input name="num1"><br>
		최대가격:<input name="num2"><br>
		<button>검색</button>
	</form>
	
	<h1>가격인상</h1>
	<form action="update.newPrice">
		물품가격:<input name="p_price"><br>
		인상가격:<input name="newPrice"><br>
		<button>검색</button>
	</form>

</body>
</html>