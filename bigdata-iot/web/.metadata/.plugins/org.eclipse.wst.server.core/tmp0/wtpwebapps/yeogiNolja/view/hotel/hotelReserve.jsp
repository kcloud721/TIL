<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Booking Form HTML Template</title>

<link href="https://fonts.googleapis.com/css?family=Raleway:400,700"
	rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="css/reserve/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/reserve/style.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#adult").val(${booking.adult});
		$("#roomNum").val(${booking.roomNum});
		});
	</script>
</head>

<body>
	<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="booking-form">
						<div class="form-header">
							<h1>Confirm your reservation</h1>
						</div>
						<form action="reserveImpl.mc" method="post">
							<input type="hidden" name="hotel_id" value="${hotel.hotel_id }">
							<input type="hidden" name="room_id" value="${room.room_id }">
							<input type="hidden" name="user_email" value="${user.email }">
							<div class="form-group">
								<input class="form-control" type="text" placeholder="hotelName"
									value="${hotel.name}"> <span class="form-label">Hotel
									Name</span>
							</div>
							<div class="form-group">
								<input class="form-control" type="text" placeholder="roomName"
									value="${room.room_name}"> <span class="form-label">room
									Name</span>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<input class="form-control" type="date" name="start_date"
											value="${booking.inDate }"> <span class="form-label">Check
											In</span>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input class="form-control" type="date" name="end_date"
											value="${booking.outDate }"> <span class="form-label">Check
											out</span>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<select class="form-control" id="roomNum">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
										</select> <span class="select-arrow"></span> <span class="form-label">Rooms</span>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<select class="form-control" id="adult">
											<option>1</option>
											<option>2</option>
											<option>3</option>
										</select> <span class="select-arrow"></span> <span class="form-label">Adults</span>
									</div>
								</div>

							</div>

							<div class="row">
								<div class="col-md-6">
									<div class="form-btn">
										<button class="submit-btn" name="pay_yn" value="N">book
											Now</button>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-btn">
										<button class="submit-btn" name="pay_yn" value="Y">pay
											Now</button>
									</div>
								</div>

							</div>


						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="css/reserve/js/jquery.min.js"></script>
	<script>
		$('.form-control').each(function() {
			floatedLabel($(this));
		});

		$('.form-control').on('input', function() {
			floatedLabel($(this));
		});

		function floatedLabel(input) {
			var $field = input.closest('.form-group');
			if (input.val()) {
				$field.addClass('input-not-empty');
			} else {
				$field.removeClass('input-not-empty');
			}
		}
	</script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>