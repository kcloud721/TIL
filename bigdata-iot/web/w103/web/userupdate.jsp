<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<div id="center">
<h1>User Update Page</h1>
<form action="userupdateimpl.mc" method="post">
	ID: ${userupdate.id } 
		<input type="hidden" name="id" value=${userupdate.id } ><br>
	PWD: <input type="password" name="pwd" value=${userupdate.pwd } ><br>
	NAME: <input type="text" name="name" value=${userupdate.name }><br>
	<input type="submit" value="UPDATE">
</form>
<!-- 
${userdetail.usersItems }  
 -->
</div>