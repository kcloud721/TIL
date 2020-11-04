<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String lat = request.getParameter("lat");
	String lng = request.getParameter("lng");
	System.out.println(lat + " ||| "+ lng);

%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		setInterval(function() {
			$('#d1').append(<%=lat%> + ' ' + <%=lng%> + '<br>');
		}, 5000);
	});
</script>


<div id="d1">DAFDSF</div>
