<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="app-page-title">
	<div class="page-title-wrapper">
		<div class="page-title-heading">
			<div class="page-title-icon">
				<i class="pe-7s-drawer icon-gradient bg-happy-itmeo"> </i>
			</div>
			<div>
				Hotel List
				<div class="page-title-subheading">Tables are the backbone of
					almost all web applications.</div>
			</div>
		</div>
		<div class="page-title-actions">
			<button type="button" data-toggle="tooltip" title="Example Tooltip"
				data-placement="bottom" class="btn-shadow mr-3 btn btn-dark">
				<i class="fa fa-star"></i>
			</button>
		</div>
	</div>
</div>

<jsp:include page="${message}"></jsp:include>

<div class="row">
	<div class="col-lg-6-2">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<h5 class="card-title">ALL Hotels</h5>
				<table class="mb-0 table">
					<thead>
						<tr>
							<th>ID</th>
							<th>NAME</th>
							<th>GRADE</th>
							<th>ROOMS</th>
							<th>ADDRESS</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="hlist" items="${hotelList}">
							<tr>
								<th scope="row">${hlist.hotel_id}</th>
								<td><a href="hotelDetail.mc?id=${hlist.hotel_id}">${hlist.name}</a></td>
								<td>${hlist.grade}</td>
								<td>${hlist.total_room}</td>
								<td>${hlist.addr_sd} ${hlist.addr_sgg} ${hlist.addr_emd}</td>	
								<td>
									<button class="mb-2 mr-2 btn-transition btn btn-outline-success" 
									onclick="location.href='hotelDetail.mc?id=${hlist.hotel_id}'">View</button>
									<button class="mb-2 mr-2 btn-transition btn btn-outline-info" 
									onclick="location.href='adminHotelModify.mc?id=${hlist.hotel_id}'">Edit</button>
									<button class="mb-2 mr-2 btn-transition btn btn-outline-danger">
									<i class="pe-7s-trash btn-icon-wrapper"> </i></button>
								</td>					
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
