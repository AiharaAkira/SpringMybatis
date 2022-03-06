<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function del(val) {
	let ok = confirm('삭제??');
	if(ok){
		location.href='menu.del.do?m_no='+val;
	}
}

function update(nooo) {
	let price = prompt('수정할 가격??');
	
	if(price != '' && price != null){
		location.href='menu.update.do?m_no='+nooo+'&m_price='+price;
	}
	
	
}
</script>
</head>
<body>
	<c:forEach var="m" items="${menus}">
		<h3>메뉴명:${m.m_name}</h3>
		<h3>메뉴가격:${m.m_price}</h3>
		<button onclick="del(${m.m_no})">삭제</button>
		<button onclick="update(${m.m_no})">수정</button>
		<button onclick="location.href='menu.modify.go?m_no=${m.m_no}'">수정(jsp)</button>
		<button onclick="location.href='menu.detail.go?m_no=${m.m_no}'">상세 조회</button>
	</c:forEach>
		<button onclick="location.href='home'">홈으로</button>
	
	
</body>
</html>