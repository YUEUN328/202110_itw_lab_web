<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP 2</title>
        <link rel="stylesheet" href="css/mystyle.css" />
    </head>
    <body>
        
        <%-- JSP (메인) 페이지에서 다른 JSP, JSPF, HTML을 포함시키고자 할 때, 
             <%@ include %> 지시자를 사용.
             include 지시자가 사용된 위치에 해당 내용들이 삽입된 후, 하나의 자바 서블릿 클래스로 변환.
        --%>
        <%@ include file="05_header.jspf"%>
        
        <section class="main">
	        <h1>include directive(지시자)</h1>
	        <h2>메인 페이지</h2>
        </section>
        
        <%@ include file="05_footer.jsp" %>
        
    </body>
</html>