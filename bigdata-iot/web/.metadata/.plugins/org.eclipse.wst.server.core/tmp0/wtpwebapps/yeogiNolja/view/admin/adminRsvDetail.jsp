<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=238179f228ad1dcc201f832e9e25eced"></script>

<div class="app-page-title">
	<div class="page-title-wrapper">
		<div class="page-title-heading">
			<div class="page-title-icon">
				<i class="pe-7s-diamond icon-gradient bg-strong-bliss"> </i>
			</div>
			<div>
				${rsv.name}'s Reservation Detail
				<div class="page-title-subheading">Tables are the backbone of
					almost all web applications.</div>
			</div>
		</div>
		<div class="page-title-actions">
			<button class="mb-2 mr-2 btn btn-info"
				onclick="location.href='adminRsvModify.mc?id=${rsv.rsv_id}'">
				Edit</button>
			<button class="mb-2 mr-2 btn btn-danger">
				Delete</button>
		</div>
	</div>
</div>

<jsp:include page="${message}"></jsp:include>

<div class="row">
	<div class="col-lg-6-2">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<h5 class="card-title">Reservation Information</h5>
				<table class="mb-0 table">
					<tbody>
						<tr>
							<th>Reservation ID</th>
							<td>${rsv.rsv_id}</td>
						</tr>
						<tr>
							<th>Customer</th>
							<td><a href="" data-toggle="modal" data-target="#modalUser">${rsv.name}</a> (${rsv.user_email})</td>
						</tr>
						<tr>
							<th>Hotel</th>
							<td><a href="" data-toggle="modal" data-target="#modalHotel">${rsv.hotel_name}</a>
							</td>
						</tr>
						<tr>
							<th>Room </th>
							<td><a href="" data-toggle="modal" data-target="#modalRoom">${rsv.room_name}</a></td>
						</tr>
						<tr>
							<th>Period</th>
							<td><fmt:parseDate value="${rsv.start_date}" var="startDate" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${startDate}" pattern="yyyy-MM-dd"/>
								 ~ 
								<fmt:parseDate value="${rsv.end_date}" var="endDate" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
							<th>PRICE</th>
							<td>&#8361; <fmt:formatNumber value="${rsv.price}" pattern="###,###,###"/> &nbsp;
							<c:if test="${rsv.pay_yn == 'Y' || rsv.pay_yn == 'y'}">
								<div class="mb-2 mr-2 badge badge-pill badge-success">Pay Complete</div></c:if>
							<c:if test="${rsv.pay_yn == 'N' || rsv.pay_yn == 'n'}">
								<div class="mb-2 mr-2 badge badge-pill badge-danger">Not Paid</div></c:if>
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="col-md-6">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<div class="card-title">Photo</div>
				<img src="img/hotel/${rsv.hotel_img }" width=100% height=300px>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<div class="card-title">Maps</div>
				<div id="map" style="width:100%;height:300px;"></div>
			</div>
		</div>
	</div>
</div>


<!-- Modal -->
<div class="modal fade" id="modalHotel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">${rsv.hotel_name}</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
				<table class="mb-0 table">
					<tr>
						<th>Hotel ID</th>
						<td>${rsv.hotel_id}</td>
					</tr>
					<tr>
						<th>NAME</th>
						<td>${rsv.hotel_name}</td>
					</tr>
					<tr>
						<th>Address</th>
						<td>${rsv.addr_sd} ${rsv.addr_sgg} ${rsv.addr_emd}</td>
					</tr>
					<tr>
						<th>Rooms</th>
						<td>${rsv.total_room} </td>
					</tr>
					<tr>
						<th>Amenities</th>
						<td>${rsv.amenities}</td>
					</tr>
					<tr>
						<th>Photo</th>
						<td><img src="./img/hotel/${rsv.hotel_img}" width=100%></td>
					</tr>
				</table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalUser" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">${rsv.name} 님</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
				<table class="mb-0 table">
					<tr>
						<th>NAME</th>
						<td>${rsv.name}</td>
					</tr>
					<tr>
						<th>E-MAIL</th>
						<td>${rsv.user_email}</td>
					</tr>
					<tr>
						<th>Admin</th>
						<td>${rsv.admin_yn} </td>
					</tr>
				</table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalRoom" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Room Information</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
				<table class="mb-0 table">
					<tr>
						<th>Hotel</th>
						<td>${rsv.hotel_name}</td>
					</tr>
					<tr>
						<th>Room</th>
						<td>${rsv.room_name}</td>
					</tr>
					<tr>
						<th>Number</th>
						<td>No. ${rsv.room_num}</td>
					</tr>
					<tr>
						<th>Adults</th>
						<td>${rsv.adults}</td>
					</tr>
					<tr>
						<th>Price</th>
						<td>&#8361; <fmt:formatNumber value="${rsv.price}" pattern="###,###,###"/></td>
					</tr>
					<tr>
						<th>Rooms</th>
						<td>${rsv.total_room} </td>
					</tr>
					<tr>
						<th>Amenities</th>
						<td>${rsv.amenities}</td>
					</tr>
					<tr>
						<th>Photo</th>
						<td><img src="./img/room/${rsv.room_img}" width=100%></td>
					</tr>
				</table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script>
var maplon = ${rsv.lon};
var maplat = ${rsv.lat};

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(maplon+0.0002, maplat), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(maplon, maplat); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);    

// 커스텀 오버레이에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
var content = '<div class="customoverlay">' +
    '    <span class="title">${rsv.hotel_name}</span>' +
    '</div>';

// 커스텀 오버레이가 표시될 위치입니다 
var position = new kakao.maps.LatLng(maplon, maplat);  

// 커스텀 오버레이를 생성합니다
var customOverlay = new kakao.maps.CustomOverlay({
    map: map,
    position: position,
    content: content,
    yAnchor: 1 
});

</script>