<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>회원정보 수정</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="css/register/fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/register/style.css">
</head>
<body>
	<header>
		<p>${user.name}님
			| <a href="main.mc">메인페이지 </a> | <a href="myReserve.mc">나의 예약 확</a>
			| <a href="logout.mc">logout</a>
		</p>
	</header>
	<div class="main">

		<section class="signup">
			<!-- <img src="images/signup-bg.jpg" alt=""> -->
			<div class="container">
				<div class="signup-content">
					<form method="POST" action="userupdateimpl.mc" id="signup-form"
						class="signup-form">
						<h2 class="form-title">회원정보 수정</h2>
						<p>Email: ${user.email } / 이름: ${user.name }</p>

						<div class="form-group">
							email: <input type="email" class="form-input" name="email"
								id="email" value="${user.email }" disabled /> <input
								type="hidden" name="email" value="${user.email }">
						</div>
						<div class="form-group">
							비밀번호: <input type="password" class="form-input" name="pwd"
								id="password" value="${user.pwd }" /> <span toggle="#password"
								class="zmdi zmdi-eye field-icon toggle-password"></span>
						</div>
						<div class="form-group">
							이름: <input type="text" class="form-input" name="name" id="name"
								placeholder="Your Name" value="${user.name }" />
						</div>

						<div class="form-group">
							<input type="submit" name="submit" id="submit"
								class="form-submit" value="정보 수정 " />
						</div>
					</form>
				</div>
			</div>
		</section>

	</div>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>