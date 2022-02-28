<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.loginMember != null }">
	<table id="communityMemberArea" style="bottom:-500px;">
		<tr>
			<td align="center">
				<span id="communityMemberSummoner">
					<img src="resources/img/people.png" style="background-color: #000000BF; border-radius:10px; padding: 5px;">
				</span>
			</td>
		</tr>
		<tr>
			<td align="center">
				<div id="communityMemberArea2">
					<c:forEach var="m" items="${members }">
						<table class="aMember" onclick="sendCommunityMsg('${m.m_id}');">
							<tr>
								<td class="aMemberImgTd" align="center" rowspan="2">
									<img src="resources/img/${m.m_photo }">
								</td>
								<td class="aMemberID">${m.m_id }</td>
							</tr>
							<tr>
								<td align="right" class="aMemberName">${m.m_name }&nbsp;</td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</td>
		</tr>
	</table>
</c:if>

	<div id="communityMsgArea">
		<c:forEach var="m" items="${msgs }">
			<table class="aCMsg">
				<tr>
					<td align="right"><span style="font-size: 7pt; cursor: pointer;"
						onclick="deleteCommunityMsg(${m.c_no});">X</span></td>
				</tr>
				<tr>
					<td class="aCMsgFrom" onclick="sendCommunityMsg('${m.c_from}');">&nbsp;${m.c_from }
					</td>
				</tr>
				<tr>
					<td align="right" class="aCMsgDate">
						<fmt:formatDate value="${m.c_when }" type="both" dateStyle="short" timeStyle="short"/>
					<br>
						<hr></td>
				</tr>
				<tr>
					<td class="aCMsgTxt">${m.c_txt }</td>
				</tr>
			</table>
		</c:forEach>
	</div>









</body>
</html>