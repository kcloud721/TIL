<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
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
			url : 'hotelListAutoCom.mc',
			async : false,

			success : function(result) {
				console.log("autoComplete ok");
				setAutoComplete(result.data);
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

	function setInOutDate(){
		$("#alert-danger").hide();

		$("#outDate").on("change keyup paste", function(){
			var inDate = $("#inDate").val();
			var outDate = $("#outDate").val();
			
			if(inDate != "" || outDate != ""){
				if(inDate > outDate){
					$("#alert-danger").show();				
				}
				if(inDate <= outDate){
					$("#alert-danger").hide();	
				}
			}
		});
	}
	$(document).ready(function() {
		getHotelListData();
		setInOutDate();
		var today = getDateFormat(new Date());
		document.getElementById("inDate").setAttribute("min", today);
		document.getElementById("outDate").setAttribute("min",  today);

		
		$("#adult").val(${booking.adult});
		$("#roomNum").val(${booking.roomNum});
		
	});
</script>

<div class="booking-form">
	<form action="bookingImpl.mc" method="post">
		<div class="form-group">

			<span class="form-label">Your Destination</span> <input
				class="form-control" type="text"
				placeholder="Enter a destination or hotel name" name="dest"
				id="dest" value="${booking.dest}" required>

		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<span class="form-label">Check In</span> <input
						class="form-control" type="date" name="inDate" id="inDate"
						value="${booking.inDate}" required>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<span class="form-label">Check out</span> <input
						class="form-control" type="date" name="outDate" id="outDate"
						value="${booking.outDate}" required>
					<div class="alert alert-danger" id="alert-danger">checkOut은
						checkIn이후여야 합니다.</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<span class="form-label">Rooms</span> <select class="form-control"
						name="roomNum" id="roomNum">
						<option>1</option>
						<option>2</option>
						<option>3</option>
					</select> <span class="select-arrow"></span>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<span class="form-label">Adults</span> <select class="form-control"
						name="adult" id="adult">
						<option>1</option>
						<option>2</option>
						<option>3</option>
					</select> <span class="select-arrow"></span>
				</div>
			</div>

		</div>
		<button class="submit-btn" type="submit">Check availability</button>
	</form>
</div>
