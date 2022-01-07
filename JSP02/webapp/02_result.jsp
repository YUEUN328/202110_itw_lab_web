<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP 2</title>
	</head>
	<body>
		<h1>사용자 이름 결과 페이지</h1>
		
		<% // scriptlet 
		request.setCharacterEncoding("UTF-8"); // 요청 데이터의 문자열 인코딩 방식 설정
		String userName = request.getParameter("userName"); // form에서 userName으로 전달한 파라미터 값
		%>
		
		<hr>
		<h1>out 객체 직접 사용</h1>
		<%
		if (userName.equals("admin")) {
			out.print("<h2 style='background-color: dodgerblue;'>관리자 페이지</h2>");
		} else {
			out.print("<h2 style='background-color:lightgray;'>사용자 이름: " + userName + "</h2>");
		}
		%>
		
		<hr>
		<h1>scriptlet과 expression 사용</h1>
		<% if (userName.equals("admin")) { %>
		<h2 style="background-color: dodgerblue;">관리자 페이지</h2>
		<% } else { %>
		<h2 style="background-color: lightgray;">사용자 이름: <%= userName %></h2>
		<% } %>		
	</body>
</html>