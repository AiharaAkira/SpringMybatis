<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="f" items="${files }">
		<table class="aFile" style="background-color: #${f.d_category}BF; box-shadow: 0px 0px 30px #${f.d_category};">
			<tr>
				<td rowspan="2"><a href="resources/file/${f.d_file }"><img
						src="resources/img/${f.d_category }.png"></a></td>
				<td class="afTitle">${f.d_title }</td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${f.d_owner == sessionScope.loginMember.m_id }">
						<td align="right" onclick="deleteFile(${f.d_no}, '${f.d_file }');">${f.d_owner }</td>
					</c:when>
					<c:otherwise>
						<td align="right">${f.d_owner }</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
	</c:forEach>

	<div style="height: 100px;">&nbsp;</div>
	<!-- ----------------------------------------- -->
	<c:if test="${sessionScope.loginMember != null }">
		<table id="drUploadArea" style="bottom: -70px;">
			<tr>
				<td align="center"><span id="drUploadFormSummoner"> <img
						src="resources/img/upload.png"
						style="background-color: #000000BF; border-radius: 10px; padding: 5px;">
				</span></td>
			</tr>
			<tr>
				<td align="center">
					<form action="dataroom.upload" method="post"
						enctype="multipart/form-data" name="drUploadForm"
						onsubmit="return drUploadCheck();">
						<input type="hidden" name="token" value="${token }">
						<table id="drUploadTable">
							<tr>
								<td id="swtTd1"><input name="d_title" placeholder="제목"
									maxlength="25" autocomplete="off"> <input name="d_file"
									type="file"> 
								<select name="d_category">
										<option value="E57373">교재</option>
										<option value="81C784">예제</option>
										<option value="64B5F6">프로그램</option>
										<option value="FDD835">기타</option>
								</select></td>
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