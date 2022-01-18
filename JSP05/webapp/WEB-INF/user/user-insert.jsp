<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MVC</title>

		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" 
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
	</head>
	<body>
		<div class="container-fluid">
			<header class="jumbotron text-center">
				<h1>신규 회원 등록 페이지</h1>
			</header>
			
			<nav> <!-- navigation menu -->
			</nav>
			
			<form action="insert" method="post">
				<input class="form-control" 
					type="text" name="userid" placeholder="아이디" required autofocus /> 
				<br>
				<input class="form-control" 
					type="text" name="pwd" placeholder="비밀번호" required /> 
				<br>
				<input class="form-control" 
					type="text" name="email" placeholder="이메일" required />
				<br>
				<input class="btn btn-success" 
					type="submit" value="등록 완료" />
				<input class="btn btn-secondary" 
					type="reset" value="취소" />
			</form>
			
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>