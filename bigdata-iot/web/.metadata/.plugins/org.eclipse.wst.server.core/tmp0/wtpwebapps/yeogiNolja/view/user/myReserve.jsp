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

<title>나의 예약 확인</title>

<!-- Google font -->
<link href="http://fonts.googleapis.com/css?family=Playfair+Display:900"
	rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Alice:400,700"
	rel="stylesheet" type="text/css" />

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="css/style.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>
<style>
h2, p {
	color: white;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
	$(document).ready(function() {
	for (var i = 1; i <= ${rListLen}; i++) {
		var str = '#pay'+i;
		
		if($(str).val() == 'Y')
			$(str).hide();
	}
	});
</script>
<body>
	<header>
		<p>${user.name}님
			| <a href="main.mc">메인페이지 </a> | <a href="userupdate.mc">회원 정보 수정</a>
			| <a href="logout.mc">logout</a>
		</p>
	</header>
	<div class="section-center">
		<div class="container">
			<h2>${user.name}님의예약페이지입니다.</h2>
			<p>총 ${rListLen}건의 예약이 확인되었습니다.</p>
			<c:forEach var="r" items="${rList }" varStatus="status">
				<div class="row">
					<div class="booking-form">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<span class="form-label">Hotel Name</span> <input
										class="form-control" type="text" value="${r.hotel_name}"
										disabled>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<span class="form-label">Room Type</span> <input
										class="form-control" type="text" value="${r.room_name}"
										disabled>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<span class="form-label">Reservation Date</span> <input
										class="form-control" type="date" value="${r.rsv_date }"
										disabled>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<span class="form-label">Check In</span> <input
										class="form-control" type="date" value="${r.start_date }"
										disabled>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<span class="form-label">Check Out</span> <input
										class="form-control" type="date" value="${r.end_date }"
										disabled>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<span class="form-label">결제 상태</span> <input
										class="form-control" type="text" value="${r.pay_yn}" disabled>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-3">
								<div class="form-btn">
									<form action="removeReservation.mc" method="post">
										<input type="hidden" name="rsv_id" value="${r.rsv_id}">
										<button id="cancel" class="submit-btn">예약 취소하기</button>
									</form>

								</div>
							</div>
							<div class="col-md-3">
								<div class="form-btn">
									<form action="payReservation.mc" method="post">
										<input type="hidden" name="rsv_id" value="${r.rsv_id}">
										<button class="submit-btn" id="pay${status.count}"
											value="${r.pay_yn}">결제하기</button>
									</form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
</body>

</html>