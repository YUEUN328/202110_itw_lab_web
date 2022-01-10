<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>EL</title>
    </head>
    <body>
        <h1>입력 페이지</h1>
        <form action="03_result.jsp" method="get">
        	<input type="text" name="userName" placeholder="사용자 이름 입력" />
        	<br>
        	<select name="color">
        		<option value="red">빨강</option>
        		<option value="green">초록</option>
        		<option value="blue">파랑</option>
        	</select>
        	<br>
        	<input type="submit" value="전송" />
        </form>
    </body>
</html>