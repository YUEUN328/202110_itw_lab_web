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
				<h1>사용자 정보 페이지</h1>
			</header>
			
			<nav> <!-- navigation menu -->
				<ul class="nav nav-tabs">
					<li class="nav-item">
						<a class="nav-link" href="../">메인</a>
					</li>
					<li class="nav-item">
						<a  class="nav-link" href="./main">사용자 메인</a>
					</li>
				</ul>
			</nav>	
		
			<form>
				<div class="form-group">
					<label for="userid">아이디</label>
					<input class="form-control" id="userid" name="userid"
						type="text" value="${user.userid}" readonly required />
				</div>
				<div class="form-group">
					<label for="pwd">비밀번호</label>
					<input class="form-control" id="pwd" name="pwd"
						type="text" value="${user.pwd}" readonly required />
				</div>
				<div class="form-group">
					<label for="email">이메일</label>
					<input class="form-control" id="email" name="email"
						type="text" value="${user.email}" readonly required />
				</div>
				<div class="form-group">
					<label for="points">포인트</label>
					<input class="form-control" id="points" name="points"
						type="number" value="${user.points}" readonly required />
				</div>
		
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>