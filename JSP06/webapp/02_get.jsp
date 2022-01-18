<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ajax</title>
		<style>
		#target1, #target2 {
			border: 1px solid black;
		}
		</style>
		
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" 
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
	</head>
	<body>
		<h1>jQuery $.get() 함수</h1>
		<button id="btn1">jQuery get</button>
		<div id="target1">결과</div>
		
		<hr>
		<h1>jQuery $.getJSON() 함수</h1>
		<button id="btn2">jQuery getJSON</button>
		<div id="target2">결과</div>
		
		<!-- <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script> -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		<script>
		$(document).ready(function () {
			$('#btn1').click(function () {
				// XMLHttpRequest 객체 생성 -> 콜백 함수 등록(onload) -> 요청 방식, URL 설정(open) -> send
				// $.get(요청주소, 성공 콜백함수);
				$.get('test.html', function (data) {
					console.log(data); // 문자열
					$('#target1').html(data);
				});
			});
			
			$('#btn2').click(function () {
				$.getJSON('data/city.json', function (data) {
					console.log(data); // JavaScript 객체
					var content = '';
    				for (var i = 0; i < data.cities.length; i++) {
    					var name = data.cities[i].name;
    					var imgSrc = data.cities[i].img;
    					// <img alt="..." src="..." />
    					content += '<img alt="' + name + '" src="' + imgSrc + '" />'
    				}
    				$('#target2').html(content);
				});
			});
		});
		</script>
	</body>
</html>