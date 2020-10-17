<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	String id = (String)request.getAttribute("loginid");
%>

<div id="center">
	LOGIN OK<br>
	<%=id %> 환영합니다. <br>
	${loginid} 환영또합니다. <br> //auto
</div>