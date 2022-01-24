<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- response.setContentType("text/html; charset=UTF-8"); --%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<p>  The time on the server is ${serverTime}. </p>
<p>	 안녕하세요, ${userName}님!</p>

<hr>
<ul>
	<li>
		<a href="sample1">sample 1</a>
	</li>
	<li>
		<a href="sample2">sample 2</a>
	</li>
	<li>
		<a href="board/main">게시판 메인 페이지</a>
	</li>
	<li>
		<a href="board/insert">새 글 작성</a>
	</li>
	<li>
		<a href="board/insert2">새 글 작성 2</a>
	</li>
	<li>
		<a href="board/insert3">새 글 작성 3</a>
	</li>
	<li>
		<a href="board/insert4">새 글 작성 4</a>
	</li>
	<li>
		<a href="forward-test">Forward 테스트</a>
	</li>
	<li>
		<a href="redirect-test">Redirect 테스트</a>
	</li>
</ul>

</body>
</html>
