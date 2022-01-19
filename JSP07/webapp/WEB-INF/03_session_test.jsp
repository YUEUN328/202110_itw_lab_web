<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Session</title>

		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" 
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
	</head>
	<body>
		<h1>Session Test</h1>
		<h2>scriptlet</h2>
		<%
		// 세션에 저장된 userName 정보를 읽어서 화면에 표시
		String user = (String) session.getAttribute("userName");
		%>		
		<div>사용자 이름: <%=user%></div> <%-- expression --%>
		
		<h2>EL(Expression Language)</h2>
		<%-- 
		EL의 동작 방식: ${변수 이름}
		EL은 변수 이름을 순서대로 pageScope -> requestScope -> sessionScope -> applicationScope에서 찾음
		--%>
		<div>${userName}</div>
		<div>${sessionScope.userName}</div>
		<div>${sessionScope["userName"]}</div>
		
		<h1>세션 정보를 사용한 페이지 분기</h1>
		<c:if test="${userName == '관리자'}">
			<h2>관리자 페이지</h2>
		</c:if>
		<c:if test="${userName != '관리자'}">
			<h2>일반 사용자 페이지</h2>
		</c:if>
		
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>