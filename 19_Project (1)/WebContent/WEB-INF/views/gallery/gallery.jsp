<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="f" items="${files }">
		<table class="anImg">
			<tr>
				<td align="center">
					<a href="resources/img/${f.g_file }"><img src="resources/img/${f.g_file }"></a> 
				</td>
			</tr>
			<tr> 
				<td class="afTitle" align="center">
					${f.g_title }
				</td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${f.g_owner == sessionScope.loginMember.m_id }">
						<td align="right" onclick="deleteImage(${f.g_no}, '${f.g_file }');">${f.g_owner }&nbsp;</td>
					</c:when>
					<c:otherwise>
						<td align="right">${f.g_owner }&nbsp;</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
	</c:forEach>
	
	<div style="height:100px;">&nbsp;</div>
	<!-- ----------------------------------------- -->
	<c:if test="${sessionScope.loginMember != null }">
		<table id="drUploadArea" style="bottom: -70px;">
			<tr>
				<td align="center">
					<span id="drUploadFormSummoner">
						<img src="resources/img/addPhoto.png" style="background-color: #000000BF; border-radius:10px; padding: 5px;">
					</span>
				</td>
			</tr>
			<tr>
				<td align="center">
					<form action="gallery.upload" method="post" 
						enctype="multipart/form-data"
						name="gUploadForm" onsubmit="return gUploadCheck();">
						<input type="hidden" name="token" value="${token }">
						<table id="drUploadTable">
							<tr>
								<td id="swtTd1">
									<input name="g_title" placeholder="제목" maxlength="25" autocomplete="off">
									<input name="g_file" type="file">
								</td>
								<td id="swtTd2"><button>업로드</button></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</c:if>
	
	
</body>
</html>