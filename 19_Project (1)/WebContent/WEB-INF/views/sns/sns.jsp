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


	<form action="sns.search" name="snsSearchForm" onsubmit="return snsSearchCheck();">
		<table id="snsSearchArea">
			<tr>
				<td id="ssaTd1"><input name="search" maxlength="10" autocomplete="off"></td>
				<td id="ssaTd2"><button>검색</button></td>
				<td><img id="snsSearchFormSummoner" src="resources/img/search.png"></td>
			</tr>
		</table>
	</form>


	<c:if test="${curPage != 1 }">
		<a href="sns.page.change?p=${curPage - 1 }" id="snsL">&lt;</a>
	</c:if>
	<c:if test="${curPage != pageCount }">
		<a href="sns.page.change?p=${curPage + 1 }" id="snsR">&gt;</a>
	</c:if>



	<c:forEach var="m" items="${msgs }">

		<table class="aSNSMsg">
			<tr>
				<td class="asmImgTd" align="center" valign="top" rowspan="4">
				<img src="resources/file/${m.m_photo }"></td>

				<td class="asmOwner">${m.s_owner }</td>
			</tr>
			<tr>
				<td><fmt:formatDate value="${m.s_date }" type="both"
						dateStyle="short" timeStyle="short" /></td>
			</tr>
			<tr>
				<td class="asmTxt">${m.s_txt }</td>
			</tr>

			<tr>
				<td class="asmReply">
					<c:forEach var="sr" items="${m.s_replys }">
						<span class="asmrOwner">${sr.r_owner }</span>-&nbsp;${sr.r_txt }&nbsp;
						<span class="asmrWhen">(<fmt:formatDate value="${sr.r_when }" type="both" dateStyle="short" timeStyle="short"/>)</span>
						<c:if test="${sr.r_owner == sessionScope.loginMember.m_id }">
							<button class="asmrBtn" 
							onclick="deleteSNSReply(${sr.r_no}, ${curPage });">삭제</button>
						</c:if>
						<br>
					</c:forEach>
					<c:if test="${sessionScope.loginMember != null }">
						<form action="sns.reply.write"  
							onsubmit="return snsWriteReplyCheck(this);">
							<span class="asmrOwner">
								${sessionScope.loginMember.m_id }
							</span> 
							<input type="hidden" name="token" value="${token }">
							<input type="hidden" name="r_s_no" value="${m.s_no }">
							<input type="hidden" name="p" value="${curPage }">
							<input class="asmrInput" name="r_txt" maxlength="80" autocomplete="off">
							<button class="asmrBtn">쓰기</button>
						</form>
					</c:if>
				</td>
			</tr>

			<c:if test="${m.s_owner == sessionScope.loginMember.m_id }">
				<tr>
					<td colspan="2" align="right">
						<button
							onclick="updateSNSMsg(${m.s_no}, '${m.s_txt}', ${curPage });"
							class="aSNSMsgBtn">수정</button>
						<button onclick="deleteSNSMsg(${m.s_no});" class="aSNSMsgBtn">삭제</button>
					</td>
				</tr>
			</c:if>
		</table>
	</c:forEach>


<!--  로그인한 사람만 쓸 수 있게 -->
<c:if test="${sessionScope.loginMember != null }">
	<table id="snsWriteArea" style="bottom: -150px">
		<tr>
			<td align="center"><span id="snsWriteFormSummoner"> <img
					src="resources/img/write.png"
					style="background-color: #000000BF; border-radius: 10px; padding: 5px;">
			</span></td>
		</tr>
		<tr>
			<td align="center">
				<form name="snsWriteForm" action="sns.write" method="get">
					<input name="token" value="${token }">
					<table id="snsWriteTable">
						<tr>
							<td id="swtTd1"><textarea name="s_txt" maxlength="200"></textarea></td>
							<td id="swtTd2"><button>쓰기</button></td>
						</tr>
					</table>
				</form>

			</td>
		</tr>
	</table>
	</c:if>















</body>
</html>