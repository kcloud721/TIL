<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	function getDateFormat(date) {
		var dd = date.getDate();
		var mm = date.getMonth() + 1;
		var yyyy = date.getFullYear();
		if (dd < 10) {
			dd = '0' + dd
		}
		if (mm < 10) {
			mm = '0' + mm
		}

		return today = "" + yyyy + '-' + mm + '-' + dd;
	}

	function getHotelListData() {
		$.ajax({
			url : 'adminAutoCom.mc',
			async : false,

			success : function(result) {
				console.log("autoComplete ok");
				setAutoComplete(result.data);
				setAutoComplete2(result.dataUser);
			},
			error : function() {
				console.log("autoComplete Fail");
			}
		});
	}

	function setAutoComplete(searchSource) {
		$("#dest").autocomplete({
			source : searchSource,
			select : function(event, ui) {
				console.log(ui.item);
			},
			focus : function(event, ui) {
				return false;
			},
			minLength : 1,
			autoFocus : true,
			classes : {
				"ui-autocomplete" : "highlight"
			},
			position : {
				my : "right top",
				at : "right bottom"
			},
			close : function(event) {
				console.log(event);
			}
		});

	}
	
	function setAutoComplete2(searchSource) {
		$("#user").autocomplete({
			source : searchSource,
			select : function(event, ui) {
				console.log(ui.item);
			},
			focus : function(event, ui) {
				return false;
			},
			minLength : 1,
			autoFocus : true,
			classes : {
				"ui-autocomplete" : "highlight"
			},
			position : {
				my : "right top",
				at : "right bottom"
			},
			close : function(event) {
				console.log(event);
			}
		});

	}

	$(document).ready(function() {
		getHotelListData();
		var today = getDateFormat(new Date());
		document.getElementById("inDate").setAttribute("min", today);
		document.getElementById("outDate").setAttribute("min",  today);

		$("#outDate").on("change keyup paste", function(){
			var inDate = $("#inDate").val();
			var outDate = $("#outDate").val();
			
			if(inDate > outDate){
			alert("checkOut은 checkIn이후여야 합니다.");
			$(this).val('');
			}
				
		});
		$("#adult").val(${booking.adult});
		$("#roomNum").val(${booking.roomNum});
		
	});
</script>
<div class="app-page-title">
	<div class="page-title-wrapper">
		<div class="page-title-heading">
			<div class="page-title-icon">
				<i class="pe-7s-magic-wand icon-gradient bg-mixed-hopes"> </i>
			</div>
			<div>
				Reservations
				<div class="page-title-subheading">Tables are the backbone of
					almost all web applications.</div>
			</div>
		</div>
		<div class="page-title-actions">
			<button type="button" data-toggle="tooltip" title="Example Tooltip"
				data-placement="bottom" class="btn-shadow mr-3 btn btn-dark">
				<i class="fa fa-star"></i>
			</button>
			<div class="d-inline-block dropdown">
				<button type="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"
					class="btn-shadow dropdown-toggle btn btn-info">
					<span class="btn-icon-wrapper pr-2 opacity-7"> <i
						class="fa fa-business-time fa-w-20"></i>
					</span> Buttons
				</button>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-6">
		<div class="main-card mb-3 card">
			<div class="card-body">
			<form action="adminRsvSearchDateImpl.mc" method="post">
				<h5 class="card-title">Search </h5>
				<div class="form-row">
					<div class="col-md-6"> 
					<div class="position-relative form-group"> <span class="form-label"> <font color="red">* </font>
							Start Date</span> <input
							class="form-control" type="date" name="start_date"
							value="${requestInfo.start_date}" required > </div>
					</div>
					<div class="col-md-6"> 
					<div class="position-relative form-group"> <span class="form-label"> <font color="red">* </font>
							End Date</span> <input
							class="form-control" type="date" name="end_date"
							value="${requestInfo.end_date}" required > </div>
					</div>
				</div>
				<div class="form-row">
					<div class="col-lg-6-2">		
					<div class="position-relative form-group"> <span class="form-label">Hotel Name</span> <input
						class="form-control" type="text"
						placeholder="Optional" name="hotel_name"
						id="dest" > </div>
					</div>
				</div>
				<div class="form-row">
					<div class="col-lg-6-2">
					<div class="position-relative form-group"> <span class="form-label">User Name</span> <input
						class="form-control" type="text"
						placeholder="Optional" name="name"
						id="user" > </div>
					</div>
				</div>
				<button class="mt-1 btn btn-primary" type="submit">Search</button>
			</form>
			</div>
		</div>		
	</div>
	<div class="col-lg-6">
	<!-- null -->
	</div>
	<div class="col-lg-6-2">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<h5 class="card-title">About Results</h5>
				<table class="mb-0 table">
					<thead>
						<tr>
							<th>R. ID</th>
							<th>HOTEL</th>
							<th>ROOM</th>
							<th>USER</th>
							<th>CHECK IN</th>
							<th>CHECK OUT</th>
							<th>ACTIONS</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rsv" items="${reserveList}">
							<tr>
								<td scope="row"><a href="adminRsvDetail.mc?id=${rsv.rsv_id}">
									${rsv.rsv_id}</a></td>
								<td>${rsv.hotel_name}</td>
								<td>${rsv.room_name}</td>
								<td>${rsv.name}</td>
								<td>
									<fmt:parseDate value="${rsv.start_date}" var="startDate" pattern="yyyy-MM-dd"/>
									<fmt:formatDate value="${startDate}" pattern="yyyy-MM-dd"/>
								</td>
								<td>
									<fmt:parseDate value="${rsv.end_date}" var="endDate" pattern="yyyy-MM-dd"/>
									<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd"/>
								</td>
								<td>
									<button class="mr-2 btn-icon btn-icon-only btn btn-outline-success" 
									onclick="location.href='adminRsvDetail.mc?id=${rsv.rsv_id}'">View</button>
									<button class="mr-2 btn-icon btn-icon-only btn btn-outline-info" 
									onclick="location.href='adminRsvModify.mc?id=${rsv.rsv_id}'">Edit</button>
									<button class="mr-2 btn-icon btn-icon-only btn btn-outline-danger">
									<i class="pe-7s-trash btn-icon-wrapper"> </i> </button>
								</td>					
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
