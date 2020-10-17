<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	header{
		width: 700px;
		height: auto;
		background: #D0D0D0;
		margin: 0 auto;
	}
	header > ul {
	margin:0 auto;
	width:700px;
	list-style: none;
	}
	header > ul > li{
		float: left;
		margin: 0 10px;
	}
	section{
		width: 700px;
		height: 600px;
		background: #F0F0F0;
		margin: 0 auto;
	}
	section > #center{
		width: 700px;
		background: #gray;
		text-align: center;
	}
	footer{
		width: 700px;
		height: 30px;
		background: gray;
		margin: 0 auto;
	}
</style>
</head>
<body>
<header>
	main page <br>
	<ul>
		<li><a href="main.nhn">main</a></li>
		<li><a href="login.nhn">login</a> </li>
		<li><a href="register.nhn">register</a> </li>
		<li><a href="userlist.nhn">user list </a> </li>
	</ul>
</header>

<section>
	<c:choose>
		<c:when test="${centerpage == null }">
			<jsp:include page="center.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="${centerpage}.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
	
</section>

<footer>
</footer>



</body>
</html>