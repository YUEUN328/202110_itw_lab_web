<%@page import="java.util.ArrayList"%>
<%@page import="edu.web.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP</title>
        <style>
        table, th, td {
        	border-bottom: 1px solid gray;
        	border-collapse: collapse;
        }
        </style>
    </head>
    <body>
        <h1>JSP Scriptlet을 사용한 테이블 작성</h1>
        <h2>Model class 테스트</h2>
        
        <%
        Member admin = new Member("admin", "1234", "admin@itwill.co.kr");
        %>
        <div><%= admin %> <%-- admin.toString() 호출 --%>
        </div>
        
        <%-- 테이블을 만들 더미 데이터 생성 --%>
        <%
        ArrayList<Member> list = new ArrayList<>();
        list.add(admin);
        list.add(new Member("guest", "guest", null));
        list.add(new Member("test", "test1234", "test@test.com"));
        list.add(new Member("오쌤", "ssam0000", "jake@itwill.co.kr"));
        %>
        
        <h2>테이블 만들기 1</h2>
    	<table>
    		<thead>
    			<tr>
    				<th>아이디</th>
    				<th>비밀번호</th>
    				<th>이메일</th>
    			</tr>
    		</thead>
    		<tbody>
    			<% 
    			for (Member m: list) {
    				out.print("<tr>");
    				out.print("<td>");
    				out.print(m.getMemberId());
    				out.print("</td>");
    				out.print("<td>");
    				out.print(m.getMemberPassword());
    				out.print("</td>");
    				out.print("<td>");
    				out.print(m.getMemberEmail());
    				out.print("</td>");
    				out.print("</tr>");
    			}
    			%>
    		</tbody>
    	</table>
    	
    	<h2>테이블 만들기 2</h2>
    	<table>
    		<thead>
    			<tr>
    				<th>Member ID</th>
    				<th>Member Password</th>
    				<th>Member Email</th>
    			</tr>
    		</thead>
    		<tbody>
    			<% for (Member m : list) { %>
    			<tr>
    				<td><%= m.getMemberId() %></td>
    				<td><%= m.getMemberPassword() %></td>
    				<td><%= m.getMemberEmail() %></td>
    			</tr>
    			<% } %>
    		</tbody>
    	</table>
        
    </body>
</html>