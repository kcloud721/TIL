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
				<i class="pe-7s-box2 icon-gradient bg-amy-crisp"> </i>
			</div>
			<div>
				Edit Reservation
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
<div class="row">
	<div class="col-lg-6-2">
		<div class="main-card mb-3 card">
			<div class="card-body">
			<form action="adminRsvModifyImpl.mc" method="post">
				<h5 class="card-title">Modify Reservation</h5>
				<table class="mb-0 table">
					<tbody>
						<tr>
							<th>Reservation ID</th>
							<th>${rsv.rsv_id}
								<input type="hidden" name="rsv_id" value="${rsv.rsv_id}">
							</th>
						</tr>
						<tr>
							<th>Customer</th>
							<td><input class="form-control" type="text"
								name="name" id="user" value="${rsv.name}" />
							</td>
						</tr>
						<tr>
							<th>Hotel</th>
							<td><input class="form-control" type="text"
								name="hotel_name" id="dest" value="${rsv.hotel_name}" />
							</td>
						</tr>
						<tr>
							<th>Room</th>
							<td><div class="custom-radio custom-control">
									<input type="radio" id="roomRadio1" class="custom-control-input"
										name="room_name" value="스탠다드" 
										<c:if test="${rsv.room_name == '스탠다드'}">checked</c:if> 
										/> <label class="custom-control-label"
										for="roomRadio1"> 스탠다드 </label>
								</div>
								<div class="custom-radio custom-control">
									<input type="radio" id="roomRadio2" class="custom-control-input"
										name="room_name" value="더블" 
										<c:if test="${rsv.room_name == '더블'}"> checked</c:if>
										/> <label class="custom-control-label"
										for="roomRadio2"> 더블 </label>
								</div>
								<div class="custom-radio custom-control">
									<input type="radio" id="roomRadio3" class="custom-control-input"
										name="room_name" value="패밀리" 
										<c:if test="${rsv.room_name == '패밀리'}">checked</c:if> 
										/> <label class="custom-control-label"
										for="roomRadio3"> 패밀리 </label>
								</div>
								<div class="custom-radio custom-control">
									<input type="radio" id="roomRadio4" class="custom-control-input"
										name="room_name" value="스위트" 
										<c:if test="${rsv.room_name == '스위트'}"> checked</c:if>
										/> <label class="custom-control-label"
										for="roomRadio4"> 스위트 </label>
								</div>
							</td>
						</tr>
						<tr>
							<th>Period</th>
								<td>
								<div class="form-row">
									<div class="col-md-6">
										<div class="position-relative form-group">
											<fmt:parseDate value='${rsv.start_date}' var='date1' pattern='yyyy-mm-dd'/>
											<fmt:formatDate value="${date1}" var='date11' pattern="yyyy-mm-dd"/>
												<span class="form-label">Check In </span> <input
													class="form-control" type="date" name="start_date"
													value="${date11}" required>
										</div>
									</div>
									<div class="col-md-6">									
										<div class="position-relative form-group">
											<fmt:parseDate value='${rsv.end_date}' var='date2' pattern='yyyy-mm-dd'/>
											<fmt:formatDate value="${date2}" var='date22' pattern="yyyy-mm-dd"/>
											<span class="form-label">Check out</span> <input
												class="form-control" type="date" name="end_date"
												value="${date22}" required>
										</div>
									</div>
								</div>
								</td>
							</tr>
						<tr>
							<th>Price</th>
							<td>&#8361; <fmt:formatNumber value="${rsv.price}" pattern="###,###,###"/></td>
						</tr>
						<tr>
							<th>Pay</th>
							<td>
								<div class="custom-radio custom-control">
									<input type="radio" id="exampleCustomRadio1" class="custom-control-input"
										name="pay_yn" value="Y" 
										<c:if test="${rsv.pay_yn == 'Y' || rsv.pay_yn == 'y'}">checked</c:if> 
										/> <label class="custom-control-label"
										for="exampleCustomRadio1"> YES </label>
								</div>
								<div class="custom-radio custom-control">
									<input type="radio" id="exampleCustomRadio2" class="custom-control-input"
										name="pay_yn" value="N" 
										<c:if test="${rsv.pay_yn == 'N' || rsv.pay_yn == 'n'}"> checked</c:if>
										/> <label class="custom-control-label"
										for="exampleCustomRadio2"> NO </label>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="card-footer d-block clearfix">
				<div class="float-right">
					<button type="submit" class="mb-2 mr-2 btn btn-primary btn-lg btn-block">Modify </button>
				</div>
			</div>
			</form>
			</div>
		</div>
	</div>
</div>
