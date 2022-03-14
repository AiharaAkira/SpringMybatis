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
		
		$('#btn').click(function() {
			
			let start = $('#start').val();
			let end = $('#end').val();
			
			
			$.getJSON("http://localhost/ajax/shop.search?start="+start+"&end="+end, function(j) {
				$("table").empty();
				console.log(j);
				//console.log(JSON.stringify(j));
				$.each(j.shops, function(i, s) {
					/* console.log(s.b_floor);
					console.log(s.b_shopName); */
					
					let td1 = $("<td></td>").text(s.b_floor);
					let td2 = $("<td></td>").text(s.b_shopName);
					let tr = $("<tr></tr>").append(td1, td2);
					$('table').append(tr);
					
					
				});
				
				$('input').keyup(function() {
					
					start = $('#start').val();
					end = $('#end').val();
					
					if(start.length >= 1 && end.length >=1){
						$("#btn").trigger("click");
					}
				});
				
				
				
				
					
				
				
				
			});
			
		});
		
	});
	
</script>
</head>
<body>
<input name="start" id="start">
<input name="end" id="end">
<button id="btn">찾기</button>
<hr>
<table border="1">
</table>

<p>
<button onclick="location.href='/ajax/shop.getjson'">json 얻기</button>
<button onclick="location.href='http://localhost/ajax/shop.getjson'">json 얻기(url 전체 작성)</button>
<button onclick="location.href='/ajax/shop.getxml'">xml 얻기</button>

</body>
</html>