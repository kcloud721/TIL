<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<div id="center">
<h1>Select All Page</h1>
<form action="detail.mc" method="post">
<table>
	<c:forEach var="u" items="${userlist }">
		<tr>
			<td>${u.id }</td>  
			<td>${u.pwd }</td>  
			<td>${u.name }</td>
			<td><button type="submit" value=${u.id }>상세보기</button>
				<button type="submit" id="">수정</button>
				<button type="submit" id="">삭제</button>
			</td>
		</tr>
	</c:forEach>
</table>
</form>
</div>