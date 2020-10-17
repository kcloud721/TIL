<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<div id="center">
<h1>Select All Page</h1>
<table>
	<c:forEach var="u" items="${userlist }">
		<tr>
			<td><a href="userdetail?id=${u.id }">${u.id }</a></td>  
			<td>${u.pwd }</td>  
			<td>${u.name }</td>
			<td><a href="userdetail?id=${u.id }">
					<button type="submit" value=${u.id }>상세보기</button></a>
				<a href="userupdate?id=${u.id }">
					<button type="submit" id="">수정</button></a>
				<a href="userdelete?id=${u.id }">
					<button type="submit" id="">삭제</button></a>
			</td>
		</tr>
	</c:forEach>
</table>
</div>