<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
img {
	width: 100%;
	height: 20%;
}
</style>
<script>
	$(document).ready(function() {
		$('#reserveButton').click(function() {
			if(${user == null} )
				alert('로그인이 필요합니다.');
		});
	});
</script>
<div class="booking-cta">
	<h1>${hotel.name}</h1>
	<p>주소 : ${hotel.addr_sd} ${hotel.addr_sgg} ${hotel.addr_emd }</p>
	<p>호텔등급: ${hotel.grade}</p>
	<p>편의시설: ${hotel.amenities }</p>
	<c:forEach var="hotelRoom" items="${hotelRoomList }">
		<form action="goReservePage.mc" method="post">
			<input type="hidden" name="hotelId" value="${hotel.hotel_id }">
			<input type="hidden" name="roomId" value="${hotelRoom.room_id }">
			<table>
				<tr>
					<td rowspan="3" style="width: 30%"><img
						src="img/room/${hotelRoom.room_img} "></td>
				</tr>
				<tr>
					<td><p>${hotelRoom.room_name}
						<p></td>
					<td rowspan="3"><button id="reserveButton">예약하기</button></td>
				</tr>
				<tr>
					<td><p>${hotelRoom.price }원</p></td>
				</tr>
			</table>
		</form>
	</c:forEach>
</div>
