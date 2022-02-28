<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/js/site_jquery.js"></script>
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<!-- 
<script type="text/javascript" src="resources/js/check.js"></script>
 -->

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/aqicn.js"></script>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/sns.css">
<link rel="stylesheet" href="resources/css/member.css">
<link rel="stylesheet" href="resources/css/dataroom.css">
<link rel="stylesheet" href="resources/css/gallery.css">
<link rel="stylesheet" href="resources/css/community.css">
</head>
<body>

	<table id="weatherArea">
		<tr>
			<td rowspan="2"><img id="weatherImg"></td>
			<td id="weatherDesc"></td>
		</tr>
		<tr>
			<td id="weatherTemp"></td>
		</tr>
	</table>



	<table id="siteTitleArea">
		<tr>
			<td align="center" id="siteMenuArea">
				<table id="siteMenu">
					<tr>
						<td align="center"><a href="sns.go"><img src="resources/img/sns.png"></a></td>
						<td align="center"><a href="dataroom.go"><img src="resources/img/dataroom.png"></a></td>
						<td align="center"><a href="gallery.go"><img src="resources/img/gallery.png"></a></td>
						<td align="center"><a href="community.go"><img src="resources/img/community.png"></a></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td id="siteTitleArea2" align="center">
				<table id="siteTitle">
					<tr>
						<td onclick="goHome()" style="z-index: 9;">자바 프로그래밍 기반 웹 융합 개발자 과정 <span id="resultArea">${result }&nbsp;<span id="city-aqi-container" style="text-shadow: none;"></span></span></td>
					</tr>
				</table>
			</td>
		</tr>


	</table>

	<table id="siteContentArea">
		<tr>
			<td align="center"><jsp:include page="${contentPage }"></jsp:include></td>
		</tr>
	</table>
	<table id="siteLoginArea">
		<tr>
			<td><jsp:include page="${loginPage }"></jsp:include></td>
		</tr>
	</table>
















</body>
</html>