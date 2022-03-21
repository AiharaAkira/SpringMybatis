<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(function() {

		//$('button').click(function() {
		$('#i1').keyup(function() {
			let inputVal = $("#i1").val();

			if ($("#i1").val() != "") {

				$.ajax({

					//서버로 보낼 주소
					url : "/ajax/menu.get.json.name",
					//요청타입
					type : 'GET',
					//요청한 데이터 형식
					dataType : 'json',
					//전송할 데이터
					data : {
						"m_name" : inputVal
					},

					//성공했을때
					success : function(data) {
						$("#mainTbl").empty();
						console.log(data);
						successcall(data); //우리가 따로 정리해서 만들라고
					}

				});
			}
		});
		
		$('#b2').click(function() {
		//$('#i1').keyup(function() {
			let inputVal = $("#i2").val();

			if ($("#i2").val() != "") {

				$.ajax({

					url : "/ajax/menu.get.xml.name",
					type : 'GET',
					dataType : 'xml',
					data : {
						"m_name" : inputVal
					},

					success : function(data) {
						$("#mainTbl").empty();
						console.log(data);
						successcall2(data); 
					}

				});
			}
		});

	});

	function successcall(data) {
		data = data["zzzz"];
		$.each(data, function(i, m) {
			//console.log(data[i]);//같은결과
			//console.log(m);//같은결과

			$("#mainTbl").append("<tr><td id='td" + i + "'></td></tr>");
			$('#td' + i).text(m.m_name);

		});
		
		
	}
	
	function successcall2(data) {
		data = $(data).find('menus');
		//console.log(data);
		$.each(data, function(i, m) {
			//console.log(data[i]);//같은결과
			//console.log(m);//같은결과
			let name = $(m).find("m_name").text();
			//console.log(name);
			$("#mainTbl").append("<tr><td>"+ name +"</td></tr>");
			//$('#td' + i).text(m.m_name);

		});
		
		
	}
</script>
</head>
<body>


	<input id="i1" autocomplete="off" placeholder="메뉴명 검색">
	<button>확인</button>
	<hr>
	<input id="i2" autocomplete="off" placeholder="메뉴명 검색">
	<button id="b2">확인</button>
	<hr>

	<a href="home1">홈1</a>
	<a href="menu.get.json">json받기</a>
	<a href="menu.get.xml">xml받기</a>
	<hr>

	<table id="mainTbl">

	</table>

</body>
</html>